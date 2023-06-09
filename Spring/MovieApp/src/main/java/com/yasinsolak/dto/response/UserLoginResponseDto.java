package com.yasinsolak.dto.response;

import com.yasinsolak.entity.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponseDto {

    private Long id;
    private String name;
    private String email;
    private EUserType userType;
}
