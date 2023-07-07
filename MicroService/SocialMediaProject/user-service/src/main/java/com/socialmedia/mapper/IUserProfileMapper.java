package com.socialmedia.mapper;

import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserProfileSaveRequestDto;
import com.socialmedia.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {
    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);
    UserProfile userProfileFromDto (UserProfileSaveRequestDto dto);
    UserProfile fromDtoToUserProfile (UserCreateRequestDto dto);
}
