package com.socialmedia.service;

import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserProfileSaveRequestDto;
import com.socialmedia.dto.request.UserUpdateRequestDto;
import com.socialmedia.exception.ErrorType;
import com.socialmedia.exception.UserProfileException;
import com.socialmedia.manager.IAuthManager;
import com.socialmedia.mapper.IUserProfileMapper;
import com.socialmedia.repository.IUserProfileRepository;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final IUserProfileRepository userProfileRepository;
    private final IAuthManager authManager;

    public UserProfileService(IUserProfileRepository userProfileRepository, IAuthManager authManager) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.authManager = authManager;
    }

    public UserProfile save (UserProfileSaveRequestDto dto){
        UserProfile userProfile = IUserProfileMapper.INSTANCE.userProfileFromDto(dto);
        return userProfileRepository.save(userProfile);
    }
    public Boolean createUser(UserCreateRequestDto dto){
       UserProfile userProfile = IUserProfileMapper.INSTANCE.fromDtoToUserProfile(dto);

        userProfileRepository.save(userProfile);
        return true;
    }

    public Boolean updateUser(UserUpdateRequestDto dto){
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findById(dto.getId());
        if(optionalUserProfile.isEmpty()){
            throw new UserProfileException(ErrorType.USER_NOT_FOUND);
        }

        userProfileRepository.save( IUserProfileMapper.INSTANCE.fromDtoToUserUpdate(dto,optionalUserProfile.get()));
        // authManager.createUser(IUserProfileMapper.INSTANCE.fromUserUpdateToAuthUpdate(dto));
        return true;
    }
}
