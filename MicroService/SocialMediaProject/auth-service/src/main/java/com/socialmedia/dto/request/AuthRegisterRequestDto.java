package com.socialmedia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRegisterRequestDto {

    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
