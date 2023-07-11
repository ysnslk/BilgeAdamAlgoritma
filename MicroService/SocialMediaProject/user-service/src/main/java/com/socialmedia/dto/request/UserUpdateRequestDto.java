package com.socialmedia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateRequestDto {
    private String id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String avatar;
    private String info;
    private String address;
}
