package com.socialmedia.exception;

import lombok.Getter;

@Getter
public class UserProfileException extends RuntimeException{

    private final ErrorType errorType;

    public UserProfileException(ErrorType errorType) {
        this.errorType = errorType;
    }
    public UserProfileException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }
}
