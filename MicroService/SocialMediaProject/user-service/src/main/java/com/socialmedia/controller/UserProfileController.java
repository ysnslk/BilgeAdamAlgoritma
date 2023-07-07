package com.socialmedia.controller;

import com.socialmedia.dto.request.UserCreateRequestDto;
import com.socialmedia.dto.request.UserProfileSaveRequestDto;
import com.socialmedia.repository.entity.UserProfile;
import com.socialmedia.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/user-profile")
@RestController
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/save")
    public UserProfile save(@RequestBody UserProfileSaveRequestDto dto){
        return userProfileService.save(dto);
    }
    @PostMapping("/create-user")
    public ResponseEntity<Boolean> createUser(@RequestBody UserCreateRequestDto dto){
        return ResponseEntity.ok(userProfileService.createUser(dto));
    }
}
