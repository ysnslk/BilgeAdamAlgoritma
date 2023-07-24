package com.socialmedia.service;

import com.socialmedia.dto.request.*;
import com.socialmedia.dto.response.AuthRegisterResponseDto;
import com.socialmedia.exception.AuthManagerException;
import com.socialmedia.exception.ErrorType;
import com.socialmedia.manager.IUserProfileManager;
import com.socialmedia.mapper.IAuthMapper;
import com.socialmedia.rabbitmq.model.MailForgotPassModel;
import com.socialmedia.rabbitmq.model.MailRegisterModel;
import com.socialmedia.rabbitmq.model.UserForgotPassModel;
import com.socialmedia.rabbitmq.producer.MailForgotPassProducer;
import com.socialmedia.rabbitmq.producer.MailRegisterProducer;
import com.socialmedia.rabbitmq.producer.UserForgotPassProducer;
import com.socialmedia.rabbitmq.producer.UserRegisterProducer;
import com.socialmedia.repository.IAuthRepository;
import com.socialmedia.repository.entity.Auth;
import com.socialmedia.repository.enums.EStatus;
import com.socialmedia.utility.CodeGenerator;
import com.socialmedia.utility.ServiceManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * Register işlemi yapalım
 * dto alsın dto dönsün
 * --> request dto
 * email, password username
 * --> response dto
 * username,id,activationCode
 * repodan controller a kadar yazalım.
 * <p>
 * login dto alalım true veya false dönsün
 * <p>
 * active status
 * --> request -> activationCode, id , kullanıcının statusunu pendingden active cekelim.
 */
@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository repository;
    private final IUserProfileManager userProfileManager;
    private final UserRegisterProducer userRegisterProducer;
    private final UserForgotPassProducer userForgotPassProducer;
    private final MailRegisterProducer mailRegisterProducer;
    private final MailForgotPassProducer mailForgotPassProducer;
    private final PasswordEncoder passwordEncoder;

    public AuthService(IAuthRepository repository, IUserProfileManager userProfileManager, UserRegisterProducer userRegisterProducer, UserForgotPassProducer userForgotPassProducer, MailRegisterProducer mailRegisterProducer, MailForgotPassProducer mailForgotPassProducer, PasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.userProfileManager = userProfileManager;
        this.userRegisterProducer = userRegisterProducer;
        this.userForgotPassProducer = userForgotPassProducer;
        this.mailRegisterProducer = mailRegisterProducer;
        this.mailForgotPassProducer = mailForgotPassProducer;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional //Rolback  ->
    public AuthRegisterResponseDto register(AuthRegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.fromAuthRegisterRequestDtotoAuth(dto);
        if (auth.getPassword().equals(dto.getRePassword())) {
            auth.setActivateCode(CodeGenerator.generatecode());
            auth.setPassword(passwordEncoder.encode(dto.getPassword()));
            save(auth);
            //1. alternatif
            UserCreateRequestDto userDto = IAuthMapper.INSTANCE.fromRegisterDtoToUserCreateDto(dto);
            userDto.setAuthId(auth.getId());
            userProfileManager.createUser(userDto);


        } else {
            throw new AuthManagerException(ErrorType.PASSWORD_ERROR);
        }
        AuthRegisterResponseDto responseDto = IAuthMapper.INSTANCE.fromAuthtoAuthRegisterResponseDto(auth);
        return responseDto;
    }

    public AuthRegisterResponseDto registerWithRabbitMQ(AuthRegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.fromAuthRegisterRequestDtotoAuth(dto);
        if (auth.getPassword().equals(dto.getRePassword())) {
            auth.setActivateCode(CodeGenerator.generatecode());
            auth.setPassword(passwordEncoder.encode(dto.getPassword()));
            save(auth);
            userRegisterProducer.sendNewUser(IAuthMapper.INSTANCE.fromAuthToUserRegisterModel(auth));
            //Mail Sender
            MailRegisterModel model = IAuthMapper.INSTANCE.fromAuthtoMailSenderModel(auth);
            model.setDecodedPassword(dto.getPassword());
            mailRegisterProducer.sendRegisterMail(model);
        } else {
            throw new AuthManagerException(ErrorType.PASSWORD_ERROR);
        }
        AuthRegisterResponseDto responseDto = IAuthMapper.INSTANCE.fromAuthtoAuthRegisterResponseDto(auth);
        return responseDto;
    }

    public Boolean login(AuthLoginRequestDto dto) {
        Optional<Auth> optionalAuth = repository.findOptionalByEmail(dto.getEmail());
        if (optionalAuth.isEmpty() || !passwordEncoder.matches(dto.getPassword(), optionalAuth.get().getPassword())) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if (!optionalAuth.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
        }
        return true;
    }

    public Boolean activeStatus(ActiveRequestDto dto) {
        Optional<Auth> auth = findById(dto.getId());
        if (auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if (auth.get().getStatus().equals(EStatus.ACTIVE)) {
            throw new AuthManagerException(ErrorType.ALREADY_ACTIVE);
        }
        if (dto.getActivationCode().equals(auth.get().getActivateCode()) && auth.get().getStatus().equals(EStatus.PENDING)) {
            auth.get().setStatus(EStatus.ACTIVE);
            update(auth.get());
            userProfileManager.activeStatus(dto.getId());
            return true;
        } else {
            throw new AuthManagerException(ErrorType.ACTIVATE_CODE_ERROR);
        }
    }

    public Boolean updateAuth(AuthUpdateRequestDto dto) {
        Optional<Auth> optionalAuth = repository.findById(dto.getAuthId());
        if (optionalAuth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        Auth auth = IAuthMapper.INSTANCE.fromAuthUpdateDtoToAuth(dto, optionalAuth.get());

        update(auth);
        return true;
    }

    @Transactional
    public Boolean DeleteAuth(Long id) {
        Optional<Auth> optionalAuth = repository.findById(id);
        if (optionalAuth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        if (optionalAuth.get().getStatus().equals(EStatus.ACTIVE) || optionalAuth.get().getStatus().equals(EStatus.PENDING)) {
            optionalAuth.get().setStatus(EStatus.DELETED);
            update(optionalAuth.get());
            userProfileManager.deleteUser(id);
            return true;
        } else {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }

    }

    public String forgotPassword(AuthForgotPasswordRequestDto dto) {
        Optional<Auth> auth = repository.findOptionalByEmail(dto.getEmail());
        if (auth.isPresent() && auth.get().getStatus().equals(EStatus.ACTIVE)) {
            //random password
            String randomPassword = UUID.randomUUID().toString();
            auth.get().setPassword(passwordEncoder.encode(randomPassword));
            save(auth.get());
            //userprofilemanager
            UserForgotPasswordRequestDto userProfileDto = UserForgotPasswordRequestDto.builder()
                    .authId(auth.get().getId())
                    .password(auth.get().getPassword())
                    .build();
            userProfileManager.forgotPassword(userProfileDto);
            mailForgotPassProducer.forgotPassSendMail(MailForgotPassModel.builder()
                            .username(auth.get().getUsername())
                    .email(auth.get().getEmail())
                    .randomPassword(randomPassword)
                    .build());
            return "Yeni şifreniz: " + randomPassword;
        }
        throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
    }

    public String forgotPasswordWithRabbitMQ(AuthForgotPasswordRequestDto dto) {
        Optional<Auth> auth = repository.findOptionalByEmail(dto.getEmail());
        if (auth.isPresent() && auth.get().getStatus().equals(EStatus.ACTIVE)) {
            //random password
            String randomPassword = UUID.randomUUID().toString();
            auth.get().setPassword(passwordEncoder.encode(randomPassword));
            save(auth.get());

            userForgotPassProducer.sendForgotPass(UserForgotPassModel.builder()

                    .authId(auth.get().getId())
                    .password(auth.get().getPassword())
                    .build());

            MailForgotPassModel model = IAuthMapper.INSTANCE.fromAuthToMailForgotPassModel(auth.get());
            model.setRandomPassword(randomPassword);
            mailForgotPassProducer.forgotPassSendMail(model);
/*

            mailForgotPassProducer.sendMailForgotPass(MailForgotPassModel.builder()
                    .username(auth.get().getUsername())
                    .password(randomPassword)
                    .email(auth.get().getEmail())
                    .build());

 */

            return "Yeni şifreniz: " + randomPassword;
        }
        throw new AuthManagerException(ErrorType.ACCOUNT_NOT_ACTIVE);
    }

    public Boolean passwordChange(ToAuthPasswordChangeRequestDto dto) {
        Optional<Auth> auth = repository.findById(dto.getAuthId());
        if (auth.isEmpty()) {
            throw new AuthManagerException(ErrorType.USER_NOT_FOUND);
        }
        auth.get().setPassword(dto.getPassword());
        update(auth.get());
        return true;
    }
}
