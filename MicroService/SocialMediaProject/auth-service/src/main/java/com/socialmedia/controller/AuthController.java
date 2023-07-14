package com.socialmedia.controller;

import com.socialmedia.dto.request.ActiveRequestDto;
import com.socialmedia.dto.request.AuthLoginRequestDto;
import com.socialmedia.dto.request.AuthRegisterRequestDto;
import com.socialmedia.dto.request.AuthUpdateRequestDto;
import com.socialmedia.dto.response.AuthRegisterResponseDto;
import com.socialmedia.repository.entity.Auth;
import com.socialmedia.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.socialmedia.constant.ApiUrls.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTH)
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<AuthRegisterResponseDto> register(@RequestBody @Valid AuthRegisterRequestDto dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody AuthLoginRequestDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping(ACTIVATE_STATUS)
    public ResponseEntity<Boolean> activeStatus(@RequestBody ActiveRequestDto dto) {
        return ResponseEntity.ok(authService.activeStatus(dto));
    }

    @PutMapping(UPDATE)
    public ResponseEntity<Boolean> updateAuth(@RequestBody AuthUpdateRequestDto dto) {
        return ResponseEntity.ok(authService.updateAuth(dto));
    }

    /**
     * @RequestBody, @RequestParam, @PathVariable --> request ve response tipleridir.
     * @RequestParam, @PathVariabl Genellikle @GetMapping ile kullanılırlar. Ama bu sadece @GetMapping ile kullanılrı anlamına gelmez.
     */
    @GetMapping(FIND_BY_ID)
    //Hiçbir tip belirlemezsek default(RequestParam) çalışır.
    //http://localhost:7070/auth/find-by-id?id=2
    public ResponseEntity<Auth> findByIdParam(@RequestParam Long id) {
        return ResponseEntity.ok(authService.findById(id).get());
    }

    @GetMapping(FIND_BY_ID + "/{id}")
    //http://localhost:7070/auth/find-by-id/2
    //Hiçbir tip belirlemezsek default(RequestParam) çalışır.
    public ResponseEntity<Auth> findByIdPathVariable(@PathVariable Long id) {
        return ResponseEntity.ok(authService.findById(id).get());
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Auth>> findAll() {
        return ResponseEntity.ok(authService.findAll());
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<Boolean> deleteAuth(Long id){
        return ResponseEntity.ok(authService.DeleteAuth(id));
    }
}
