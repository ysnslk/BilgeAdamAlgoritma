package com.socialmedia.manager;

import com.socialmedia.dto.request.AuthUpdateRequestDto;
import com.socialmedia.dto.request.ToAuthPasswordChangeRequestDto;
import com.socialmedia.dto.request.UserCreateRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${localhost.auth-manager-url}" , name = "userprofile-auth")
public interface IAuthManager {

    /**
     *  Buradaki metodun, user-profile'daki metodun dönüş tipi ile aynı olmalıdır.
     *  Ancaok metot ismi farklı olabliir. Aynı olması okunulabilirlik açısından iyidr.
     *  Metodun parametresinde bulunan veri gönderme tipi(@RequestBody @RequestParam  vs.) Aynı olmalıdır.
     *  Metodun dto parametresinin ismiyle userprofile controller metodundaki parametre isminin aynı olması okunma açısından iyidir.
     *  Dto içindeki propertylerde aynı olmalıdır.
     */

    @PutMapping("/update")
    public ResponseEntity<Boolean> updateAuth(AuthUpdateRequestDto dto);
    @PutMapping("/password-change")
    public ResponseEntity<Boolean> passwordChange(@RequestBody ToAuthPasswordChangeRequestDto dto);
}
