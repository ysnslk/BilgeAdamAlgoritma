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
public class ProductSaveRequestDto {
    @NotEmpty(message = "Ürün adı boş geçilemez")
    @Size(min = 3, max = 64, message = "Ürün adı 3 ile 64 karakter arasında olmalıdır.")
    private String name;
    private String category;
    @NotEmpty(message = "Fiyat boş geçilemez")
    private double cost;
}
