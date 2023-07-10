package com.socialmedia.service;

import com.socialmedia.dto.request.ActiveRequestDto;
import com.socialmedia.dto.request.AuthLoginRequestDto;
import com.socialmedia.dto.request.AuthRegisterRequestDto;
import com.socialmedia.dto.response.AuthRegisterResponseDto;
import com.socialmedia.exception.AuthManagerException;
import com.socialmedia.exception.ErrorType;
import com.socialmedia.manager.IUserProfileManager;
import com.socialmedia.mapper.IAuthMapper;
import com.socialmedia.repository.IAuthRepository;
import com.socialmedia.repository.entity.Auth;
import com.socialmedia.repository.enums.EStatus;
import com.socialmedia.utility.CodeGenerator;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public AuthService(IAuthRepository repository, IUserProfileManager userProfileManager) {
        super(repository);
        this.repository = repository;
        this.userProfileManager = userProfileManager;
    }


    public AuthRegisterResponseDto register(AuthRegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.fromAuthRegisterRequestDtotoAuth(dto);
        if(auth.getPassword().equals(dto.getRePassword())){
            auth.setActivateCode(CodeGenerator.generatecode());
            save(auth);
            userProfileManager.createUser(IAuthMapper.INSTANCE.fromRegisterDtoToUserCreateDto(dto));
        } else {
            throw new AuthManagerException(ErrorType.PASSWORD_ERROR);
        }
        AuthRegisterResponseDto responseDto = IAuthMapper.INSTANCE.fromAuthtoAuthRegisterResponseDto(auth);
        return responseDto;
    }

    public Boolean login(AuthLoginRequestDto dto) {
        Optional<Auth> optionalAuth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (optionalAuth.isEmpty()) {
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
        if (dto.getActivationCode().equals(auth.get().getActivateCode())) {
            auth.get().setStatus(EStatus.ACTIVE);
            update(auth.get());
            return true;
        } else {
            throw new AuthManagerException(ErrorType.INVALID_CODE);
        }
    }
}
