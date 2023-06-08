package com.yasinsolak.dto.response;

import com.yasinsolak.entity.EUserType;
import com.yasinsolak.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private List<Genre> genres;
}
