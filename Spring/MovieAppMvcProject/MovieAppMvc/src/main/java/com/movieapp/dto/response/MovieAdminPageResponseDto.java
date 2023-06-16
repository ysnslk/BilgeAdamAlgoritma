package com.movieapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieAdminPageResponseDto {
    private Long id;
    private String name;
    private String language;
    private LocalDate premiered;
}
