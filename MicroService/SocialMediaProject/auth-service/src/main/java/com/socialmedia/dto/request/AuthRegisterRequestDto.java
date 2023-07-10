package com.socialmedia.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRegisterRequestDto {
    @NotEmpty(message = "Ad alanını boş bırakmayınız")
    @Size(min = 3, max = 20, message = "Ad en az 3 en fazla 20 olabilir")
    private String name;
    @NotEmpty(message = "Soyad alanını boş bırakmayınız")
    @Size(min = 3, max = 20, message = "Soyad en az 3 en fazla 20 olabilir")
    private String surname;
    @NotEmpty(message = "Kullanıcı adını boş bırakmayınız")
    @Size(min = 3, max = 20, message = "KUllanıcı adı en az 3 en fazla 20 olabilir")
    private String username;
    @Email(message = "Lütfen geçerli bir email giriniz")
    private String email;
    @NotEmpty
    //@NotBlank   --> username = "" O alanı boş bırakma
    //@NotNull    --> username = null (Swaggerdan silinmiş)
    //@NotEmpty   --> Yukarıdaki her ikisinide kontrol eder
    @Size(min = 8, max = 32, message = "Şifre en az 8 en fazla 32 karakter olabilir.")
    private String password;
    private String rePassword;
}
