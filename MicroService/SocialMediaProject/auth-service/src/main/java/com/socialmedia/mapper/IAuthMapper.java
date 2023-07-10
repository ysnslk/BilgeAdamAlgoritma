package com.socialmedia.mapper;

import com.socialmedia.dto.request.AuthRegisterRequestDto;
import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.response.AuthRegisterResponseDto;
import com.socialmedia.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth fromAuthRegisterRequestDtotoAuth(final AuthRegisterRequestDto requestDto);
    AuthRegisterResponseDto fromAuthtoAuthRegisterResponseDto(final Auth auth);
    UserCreateRequestDto fromRegisterDtoToUserCreateDto (final AuthRegisterRequestDto dto);
}

