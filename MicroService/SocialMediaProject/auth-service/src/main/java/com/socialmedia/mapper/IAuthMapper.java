package com.socialmedia.mapper;

import com.socialmedia.dto.request.AuthRegisterRequestDto;
import com.socialmedia.dto.request.AuthUpdateRequestDto;
import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.response.AuthRegisterResponseDto;
import com.socialmedia.repository.entity.Auth;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth fromAuthRegisterRequestDtotoAuth(final AuthRegisterRequestDto requestDto);
    AuthRegisterResponseDto fromAuthtoAuthRegisterResponseDto(final Auth auth);
    UserCreateRequestDto fromRegisterDtoToUserCreateDto (final AuthRegisterRequestDto dto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "authId",target = "id")
    Auth fromAuthUpdateDtoToAuth(AuthUpdateRequestDto dto ,@MappingTarget Auth auth);

}

