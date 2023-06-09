package com.yasinsolak.dto.response;

import com.yasinsolak.entity.EUserType;
import com.yasinsolak.entity.Genre;
import com.yasinsolak.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserFindAllReponseDto {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private EUserType userType;
    private List<Genre> favGenres;
    private List<String> movieCommentsContent;
    private Map<String ,String> movieContent;
}
