package com.socialmedia.controller;

import com.socialmedia.dto.request.ActiveRequestDto;
import com.socialmedia.dto.request.AuthLoginRequestDto;
import com.socialmedia.dto.request.AuthRegisterRequestDto;
import com.socialmedia.dto.request.AuthUpdateRequestDto;
import com.socialmedia.dto.response.AuthRegisterResponseDto;
import com.socialmedia.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthRegisterResponseDto> register (@RequestBody @Valid AuthRegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login (@RequestBody AuthLoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/activestatus")
    public ResponseEntity<Boolean> activeStatus (@RequestBody ActiveRequestDto dto){
        return ResponseEntity.ok(authService.activeStatus(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateAuth(@RequestBody AuthUpdateRequestDto dto){
        return ResponseEntity.ok(authService.updateAuth(dto));
    }
}
