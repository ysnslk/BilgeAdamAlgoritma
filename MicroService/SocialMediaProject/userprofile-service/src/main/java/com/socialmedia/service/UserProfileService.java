package com.socialmedia.service;

import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserForgotPasswordRequestDto;
import com.socialmedia.dto.request.UserProfileSaveRequestDto;
import com.socialmedia.dto.request.UserUpdateRequestDto;
import com.socialmedia.exception.ErrorType;
import com.socialmedia.exception.UserProfileManagerException;
import com.socialmedia.manager.IAuthManager;
import com.socialmedia.mapper.IUserProfileMapper;
import com.socialmedia.rabbitmq.model.AuthRegisterModel;
import com.socialmedia.repository.IUserProfileRepository;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.repository.enums.EStatus;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile, String> {

    private final IUserProfileRepository userProfileRepository;
    private final IAuthManager authManager;

    public UserProfileService(IUserProfileRepository userProfileRepository, IAuthManager authManager) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.authManager = authManager;
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
    public void createUserWithRabbitMq(AuthRegisterModel model) {
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


}
