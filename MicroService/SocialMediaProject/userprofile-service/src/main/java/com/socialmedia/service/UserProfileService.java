package com.socialmedia.service;

import com.socialmedia.dto.request.*;
import com.socialmedia.exception.ErrorType;
import com.socialmedia.exception.UserProfileManagerException;
import com.socialmedia.manager.IAuthManager;
import com.socialmedia.mapper.IUserProfileMapper;
import com.socialmedia.rabbitmq.model.UserForgotPassModel;
import com.socialmedia.rabbitmq.model.UserRegisterModel;
import com.socialmedia.repository.IUserProfileRepository;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.repository.enums.EStatus;
import com.socialmedia.utility.ServiceManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, String> {

    private final IUserProfileRepository userProfileRepository;
    private final IAuthManager authManager;
    private final PasswordEncoder passwordEncoder;

    public UserProfileService(IUserProfileRepository userProfileRepository, IAuthManager authManager, PasswordEncoder passwordEncoder) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
    }

    public UserProfile save(UserProfileSaveRequestDto dto) {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.userProfileFromDto(dto);
        return userProfileRepository.save(userProfile);
    }

    public Boolean createUser(UserCreateRequestDto dto) {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.fromDtoToUserProfile(dto);

        userProfileRepository.save(userProfile);
        return true;
    }

    public void createUserWithRabbitMq(UserRegisterModel model) {
        userProfileRepository.save(IUserProfileMapper.INSTANCE.fromRegisterModelToUserProfile(model));
    }

    public Boolean updateUser(UserUpdateRequestDto dto) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(dto.getId());
        if (optionalUserProfile.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }

        userProfileRepository.save(IUserProfileMapper.INSTANCE.fromDtoToUserUpdate(dto, optionalUserProfile.get()));
        authManager.updateAuth(IUserProfileMapper.INSTANCE.fromUserProfileToAuthUpdateDto(optionalUserProfile.get()));
        return true;
    }

    public Boolean deleteUser(Long authId) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findByAuthId(authId);
        if (optionalUserProfile.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
        optionalUserProfile.get().setStatus(EStatus.DELETED);
        update(optionalUserProfile.get());
        return true;
    }

    public Boolean activeStatus(Long id) {
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findByAuthId(id);
        if (optionalUserProfile.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
        optionalUserProfile.get().setStatus(EStatus.ACTIVE);
        update(optionalUserProfile.get());
        return true;
    }

    public Boolean forgotPassword(UserForgotPasswordRequestDto dto) {
        Optional<UserProfile> userProfile = userProfileRepository.findByAuthId(dto.getAuthId());
        if (userProfile.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setPassword(dto.getPassword());
        update(userProfile.get());
        return true;
    }

    public Boolean forgotPasswordWithRabbitMq(UserForgotPassModel model) {
        Optional<UserProfile> userProfile = userProfileRepository.findByAuthId(model.getAuthId());
        if (userProfile.isEmpty()) {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
        userProfile.get().setPassword(model.getPassword());
        update(userProfile.get());
        return true;
    }

    public Boolean passwordChange(PasswordChangeDto dto) {
        Optional<UserProfile> userProfile = userProfileRepository.findById(dto.getId());
        if (userProfile.isPresent()) {
            if (passwordEncoder.matches(dto.getOldPassword(),userProfile.get().getPassword())) {
                userProfile.get().setPassword(passwordEncoder.encode(dto.getNewPassword()));
                save(userProfile.get());
                //authManager
                authManager.passwordChange(IUserProfileMapper.INSTANCE.fromUserProfileToAuthPasswordChangeDto(userProfile.get()));
                return true;
            } else {
                throw new UserProfileManagerException(ErrorType.PASSWORD_ERROR);
            }
        } else {
            throw new UserProfileManagerException(ErrorType.USER_NOT_FOUND);
        }
    }

}
