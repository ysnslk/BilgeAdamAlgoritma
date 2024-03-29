package com.socialmedia.mapper;

import com.socialmedia.dto.request.*;
import com.socialmedia.dto.response.AuthRegisterResponseDto;
import com.socialmedia.rabbitmq.model.MailForgotPassModel;
import com.socialmedia.rabbitmq.model.MailRegisterModel;
import com.socialmedia.rabbitmq.model.UserRegisterModel;
import com.socialmedia.repository.entity.Auth;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth fromAuthRegisterRequestDtotoAuth(final AuthRegisterRequestDto requestDto);

    @Mapping(source = "id", target = "authId")
    UserRegisterModel fromAuthToUserRegisterModel(final Auth auth);

    AuthRegisterResponseDto fromAuthtoAuthRegisterResponseDto(final Auth auth);
    MailRegisterModel fromAuthtoMailSenderModel(final Auth auth);

    UserCreateRequestDto fromRegisterDtoToUserCreateDto(final AuthRegisterRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "authId", target = "id")
    Auth fromAuthUpdateDtoToAuth(AuthUpdateRequestDto dto, @MappingTarget Auth auth);

    UserForgotPasswordRequestDto fromAuthForgotPassToUserForgotPassDto(AuthForgotPasswordRequestDto dto);


    MailForgotPassModel fromAuthToMailForgotPassModel(final Auth auth);
}

