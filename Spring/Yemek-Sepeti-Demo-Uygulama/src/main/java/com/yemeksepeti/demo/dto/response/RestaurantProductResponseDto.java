package com.yemeksepeti.demo.dto.response;

import com.yemeksepeti.demo.repository.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantProductResponseDto {
    private Restaurant restaurant;
}
