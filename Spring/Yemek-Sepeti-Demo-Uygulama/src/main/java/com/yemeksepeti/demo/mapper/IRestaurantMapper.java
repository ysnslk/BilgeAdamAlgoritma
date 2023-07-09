package com.yemeksepeti.demo.mapper;


import com.yemeksepeti.demo.dto.request.RestaurantSaveRequestDto;
import com.yemeksepeti.demo.dto.response.RestaurantProductResponseDto;
import com.yemeksepeti.demo.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {

    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);

    Restaurant RestaurantFromDto (RestaurantSaveRequestDto dto);
    RestaurantProductResponseDto dtoFromRestaurant (Restaurant restaurant);
}
