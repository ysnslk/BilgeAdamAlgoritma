package com.yemeksepeti.demo.controller;

import com.yemeksepeti.demo.dto.request.RestaurantSaveRequestDto;
import com.yemeksepeti.demo.dto.response.RestaurantProductResponseDto;
import com.yemeksepeti.demo.mapper.IRestaurantMapper;
import com.yemeksepeti.demo.repository.entity.Restaurant;
import com.yemeksepeti.demo.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/save")
    public Restaurant createRestaurant(@RequestBody @Valid RestaurantSaveRequestDto dto){
        Restaurant restaurant = IRestaurantMapper.INSTANCE.RestaurantFromDto(dto);
        return restaurantService.save(restaurant);
    }

    @PostMapping("/findById")
    public ResponseEntity<RestaurantProductResponseDto> productListForRestaurant(Long id){
         Optional<Restaurant> restaurantOptional= restaurantService.findById(id);
        RestaurantProductResponseDto dto =  IRestaurantMapper.INSTANCE.dtoFromRestaurant(restaurantOptional.get());
         return ResponseEntity.ok(dto);
    }
    @PostMapping("/findall")
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }
}
