package exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    //AUTH SERVİCE ERROR
    BAD_REQUEST(4000,"Parametre Hatası",HttpStatus.BAD_REQUEST),
    VALIDATION_ERROR(3000,"Validasyon Hatası",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4001,"Kullanıcı Adı Veya Şifre Hatalı",HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4002,"Bu Kullanıcı Zaten Kayıtlı",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4003,"Böyle bir kullanıcı bulunamadı.",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4004,"Hesabınız aktif değiş",HttpStatus.BAD_REQUEST),
    ACTIVATE_CODE_ERROR(4005,"Aktivasyon Kod Hayası",HttpStatus.BAD_REQUEST),
    ALREADY_ACTIVE(4006,"Hesabınız zaten aktif",HttpStatus.BAD_REQUEST),
    PASSWORD_ERROR(4007,"Şifreler Uyuşmuyor",HttpStatus.BAD_REQUEST),

    //SERVER ERROR
    INTERNAL_ERROR(500,"Beklenmedik hata",HttpStatus.INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    HttpStatus httpStatus;
}
