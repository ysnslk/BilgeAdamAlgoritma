package com.socialmedia.controller;

import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserDeleteRequestDto;
import com.socialmedia.dto.request.UserProfileSaveRequestDto;
import com.socialmedia.dto.request.UserUpdateRequestDto;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.service.UserProfileService;
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
     @PutMapping(UPDATE)
    public ResponseEntity<Boolean> updateUser(@RequestBody UserUpdateRequestDto dto){
        return ResponseEntity.ok(userProfileService.updateUser(dto));
    }
    @PostMapping(DELETE)
    public ResponseEntity<Boolean> deleteUser(@RequestBody Long authId){
         return ResponseEntity.ok(userProfileService.deleteUser(authId));
    }
}
