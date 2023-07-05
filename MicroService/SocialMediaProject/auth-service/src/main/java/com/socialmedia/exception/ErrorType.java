package com.socialmedia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    USER_NOT_FOUND(5100,"Böyle bir kullanıcı bulunamadı.",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4100,"Hesabınız aktif değiş",HttpStatus.BAD_REQUEST),
    INVALID_CODE(2100,"Hesabınız aktif değil",HttpStatus.BAD_REQUEST),
    ALREADY_ACTIVE(2200,"Hesabınız zaten aktif",HttpStatus.BAD_REQUEST),
    INTERVAL_ERROR(3100,"Beklenmedik hata",HttpStatus.INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
