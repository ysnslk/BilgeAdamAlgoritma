package com.yemeksepeti.demo.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantSaveRequestDto {
    private String name;
    private double point;
    @NotEmpty(message = "Restaurant adı boş geçilemez")
    @Size(min = 3, max = 64, message = "Restaurant adı 2 ile 64 karakter arasında olmalıdır.")
    private String address;
}
