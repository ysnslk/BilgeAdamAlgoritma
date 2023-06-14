package com.yasinsolak.mapper;

import com.yasinsolak.dto.request.UserRegisterRequestDto;
import com.yasinsolak.dto.response.UserLoginResponseDto;
import com.yasinsolak.dto.response.UserRegisterResponseDto;
import com.yasinsolak.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(final UserRegisterRequestDto dto);
    UserRegisterResponseDto toUserRegisterResponseDto(final User user);

    UserLoginResponseDto toUserLoginResponseDto(final User user);

}
