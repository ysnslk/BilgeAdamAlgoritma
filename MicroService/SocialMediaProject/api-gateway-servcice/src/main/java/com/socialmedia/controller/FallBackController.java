package com.socialmedia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {
    /**
     * CircuitBreaker --> Bu bir devre kesicidir. Gateway' e gelen isteklerde bir sorun olduğunda  servisler için bir mesaj döner.
     * Hataları tespit ederek kullanıcıya hata dönmesi yerine mesaj dönemsini sağlar.
     */

    @GetMapping("/auth-service")
    public ResponseEntity<String> authServiceFallback(){
        return ResponseEntity.ok("Auth Service Şu anda Hizmet verememektedir. Daha sonra tekrar deneyin");
    }

    @GetMapping("/user-profile-service")
    public ResponseEntity<String> userProfileServiceFallback(){
        return ResponseEntity.ok("User Profile Service Şu anda Hizmet verememektedir. Daha sonra tekrar deneyin");
    }
    @GetMapping("/mail-service")
    public ResponseEntity<String> mailServiceFallback(){
        return ResponseEntity.ok("Mail Service Şu anda Hizmet verememektedir. Daha sonra tekrar deneyin");
    }
}
