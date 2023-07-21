package com.socialmedia.mapper;

import com.socialmedia.dto.request.*;
import com.socialmedia.rabbitmq.model.UserRegisterModel;
import com.socialmedia.repository.entity.UserProfile;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {
    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);
    UserProfile userProfileFromDto (UserProfileSaveRequestDto dto);
    UserProfile fromDtoToUserProfile (UserCreateRequestDto dto);
    UserProfile fromRegisterModelToUserProfile(UserRegisterModel model);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserProfile fromDtoToUserUpdate(UserUpdateRequestDto dto,@MappingTarget UserProfile userProfile);

    AuthUpdateRequestDto fromUserProfileToAuthUpdateDto(UserProfile userProfile);
    UserProfileSaveRequestDto fromUserCreateRequestDtoToRegisterUserProfile(UserRegisterModel registerUserProfile);

    ToAuthPasswordChangeRequestDto fromUserProfileToAuthPasswordChangeDto(final UserProfile userProfile);

}
