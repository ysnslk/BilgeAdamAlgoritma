package com.movieapp.dto.response;

import com.movieapp.entity.EUserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private EUserType userType;
}
