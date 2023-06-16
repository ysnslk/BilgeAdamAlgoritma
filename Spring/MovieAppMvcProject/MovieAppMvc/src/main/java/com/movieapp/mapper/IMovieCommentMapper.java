package com.movieapp.mapper;

import com.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.movieapp.dto.response.MovieCommentSaveResponseDto;
import com.movieapp.entity.MovieComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spirng", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMovieCommentMapper {
    IMovieCommentMapper INSTANCE= Mappers.getMapper(IMovieCommentMapper.class);
    MovieComment toMovie(MovieCommentSaveRequestDto dto);
    MovieCommentSaveResponseDto toMovieCommentResponseDto(MovieComment movieComment);
}
