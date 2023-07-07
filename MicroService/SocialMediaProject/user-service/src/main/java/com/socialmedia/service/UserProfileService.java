package com.socialmedia.service;

import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserProfileSaveRequestDto;
import com.socialmedia.mapper.IUserProfileMapper;
import com.socialmedia.repository.IUserProfileRepository;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final IUserProfileRepository userProfileRepository;

    public UserProfileService(IUserProfileRepository userProfileRepository) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
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
}
