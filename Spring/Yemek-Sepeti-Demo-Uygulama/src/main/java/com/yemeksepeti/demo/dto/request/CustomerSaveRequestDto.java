package com.yemeksepeti.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerSaveRequestDto {
    @NotEmpty(message = "Ad boş geçilemez")
    @Size(min = 3, max = 64, message = "Ad 3 ile 64 karakter arasında olmalıdır.")
    private String name;
    @NotEmpty(message = "Soyad boş geçilemez")
    @Size(min = 2, max = 64, message = "Soyad 2 ile 64 karakter arasında olmalıdır.")
    private String surname;
    @Email(message = "Lütfen geçerli bir e-posta adresi giriniz")
    private String email;
    @NotEmpty(message = "Adres boş geçilemez")
    @Size(min = 3, max = 64, message = "Adres 3 ile 64 karakter arasında olmalıdır.")
    private String address;
    private String phoneNumber;
    private String password;
}
