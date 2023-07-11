package com.socialmedia.mapper;

import com.socialmedia.dto.request.AuthUpdateRequestDto;
import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserProfileSaveRequestDto;
import com.socialmedia.dto.request.UserUpdateRequestDto;
import com.socialmedia.repository.entity.UserProfile;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {
    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);
    UserProfile userProfileFromDto (UserProfileSaveRequestDto dto);
    UserProfile fromDtoToUserProfile (UserCreateRequestDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserProfile fromDtoToUserUpdate(UserUpdateRequestDto dto,@MappingTarget UserProfile userProfile);

    AuthUpdateRequestDto fromUserUpdateToAuthUpdate(UserUpdateRequestDto dto);

}
