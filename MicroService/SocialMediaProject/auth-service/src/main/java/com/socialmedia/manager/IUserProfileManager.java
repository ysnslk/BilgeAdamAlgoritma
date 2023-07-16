package com.socialmedia.manager;

import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserForgotPasswordRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(url = "http://localhost:8080/api/v1/user-profile" , name = "auth-userprofile")
public interface IUserProfileManager {

    /**
     *  Buradaki metodun, user-profile'daki metodun dönüş tipi ile aynı olmalıdır.
     *  Ancaok metot ismi farklı olabliir. Aynı olması okunulabilirlik açısından iyidr.
     *  Metodun parametresinde bulunan veri gönderme tipi(@RequestBody @RequestParam  vs.) Aynı olmalıdır.
     *  Metodun dto parametresinin ismiyle userprofile controller metodundaki parametre isminin aynı olması okunma açısından iyidir.
     *  Dto içindeki propertylerde aynı olmalıdır.
     */

    @PostMapping("/create-user")
    public ResponseEntity<Boolean> createUser(@RequestBody UserCreateRequestDto dto);
    @DeleteMapping("/delete-user")
    public ResponseEntity<Boolean> deleteUser(@RequestBody Long id);

    @PutMapping("/activate-status")
    public ResponseEntity<Boolean> activeStatus(@RequestBody Long id);

    @PutMapping("/forgot-password")
    public ResponseEntity<Boolean> forgotPassword(@RequestBody UserForgotPasswordRequestDto dto);
}
