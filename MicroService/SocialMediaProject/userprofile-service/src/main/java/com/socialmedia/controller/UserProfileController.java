package com.socialmedia.controller;

import com.socialmedia.dto.request.*;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.service.UserProfileService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.socialmedia.constant.ApiUrls.*;

@RequestMapping(USER_PROFILE)
@RestController
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(REGISTER)
    public UserProfile save(@RequestBody UserProfileSaveRequestDto dto){
        return userProfileService.save(dto);
    }
    @Hidden
    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody UserCreateRequestDto dto){
        return ResponseEntity.ok(userProfileService.createUser(dto));
    }

    /**
     * @RequestParam -->
     * @PathVariable -->
     * Delete Put Post Mapping farkları nelerdir?
     * Neden Delete, Post, Put mapping vardır diye sorduğumuzda tek fark controller metotlarını işaretlerken
     * okunabilirliği arttırmaktadır.
     * Genellikle PostMapping   -> Veri Kaydetme , veri tabanındaki değişiklik yapma işlemlerinde kullanılır.
     *            PutMapping    -> Veri tabanındaki varolan veriyi update için kullanılır.
     *            DeleteMapping -> Veri Silme işleminde kullanılır.
     */
    @Operation(summary = "Burasıda başlık",description = "Kullanıcının giriş yaptıktan sonra eksik bilgilerini doldurduğu metot")
     @PutMapping(UPDATE)
    public ResponseEntity<Boolean> updateUser(@RequestBody UserUpdateRequestDto dto){
        return ResponseEntity.ok(userProfileService.updateUser(dto));
    }
    @Hidden
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteUser(@RequestBody Long id){
         return ResponseEntity.ok(userProfileService.deleteUser(id));
    }

    @PutMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activeStatus(@RequestBody Long id){
         return ResponseEntity.ok(userProfileService.activeStatus(id));
    }
    @Hidden
    @PutMapping(FORGOT_PASSWORD)
    public ResponseEntity<Boolean> forgotPassword(@RequestBody UserForgotPasswordRequestDto dto){
         return ResponseEntity.ok(userProfileService.forgotPassword(dto));
    }
    @PutMapping(PASSWORD_CHANGE)
    public ResponseEntity<Boolean> passwordChange(PasswordChangeDto dto){
         return ResponseEntity.ok(userProfileService.passwordChange(dto));
    }
}
