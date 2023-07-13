package exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.socialmedia.exception.ErrorMessage;
import com.socialmedia.exception.ErrorType;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthManagerException.class)
    public ResponseEntity<ErrorMessage> handleManagerException(AuthManagerException exception) {
        com.socialmedia.exception.ErrorType errorType = exception.getErrorType();
        HttpStatus httpStatus = errorType.getHttpStatus();
        return new ResponseEntity<>(createError(errorType, exception), httpStatus);
    }

    private ErrorMessage createError(com.socialmedia.exception.ErrorType errorType, Exception exception) {
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception exception) {
        com.socialmedia.exception.ErrorType errorType = com.socialmedia.exception.ErrorType.INTERNAL_ERROR;
        List<String> fields = new ArrayList<>();
        fields.add(exception.getMessage());
        ErrorMessage errorMessage = createError(errorType, exception);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.ok("Beklenmeyen bir hata olustu: " + ex.getMessage());
    }

    /**
     * İstek atılırken arka tarafta belirlenen property'lerin validation kontorllerini sağlar.
     * Aşağıdaki metot bu validasyonların tipini ve mesajını döndürmek üzere tasarlanmıştır.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        com.socialmedia.exception.ErrorType errorType = com.socialmedia.exception.ErrorType.BAD_REQUEST;
        List<String> fields = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(e -> fields.add(e.getField() + ": " + e.getDefaultMessage()));
        ErrorMessage errorMessage = createError(errorType, exception);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(errorMessage, errorType.getHttpStatus());
    }

    /**
     * Http isteğinin veya yanıtının okunamaması durumunda fırlatılan hatadır.
     * JSON formatta bir verir gönderirken bu formattaki bir yanlışlık sonucunda(örn; fazladan virgül kalması, bir değerin eksik kalması)
     * fırlatılan hatadır.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorMessage> handleMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        com.socialmedia.exception.ErrorType errorType = com.socialmedia.exception.ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    /**
     * Veri Dönüşümü sırasında fırlatılan hatadır.
     * Bir parametre Date formatında bir veri beklerken, String veya Integer tipinde bir veri gönderildiğinde
     * Veri dönüşümü olmayacağı için bu hata fırlatılır.
     */
    @ExceptionHandler(InvalidFormatException.class)
    public final ResponseEntity<ErrorMessage> handleInvalidFormatException(InvalidFormatException exception) {
        com.socialmedia.exception.ErrorType errorType = com.socialmedia.exception.ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    /**
     * İki parametrenin tiplerini birbiri ile uyuşmamasından ortaya çıkan hata tipi
     * String tutulan bir parametrenin(değişken) integer olarka gönderilmesi sırasında fırlatılan hatadır.
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(MethodArgumentTypeMismatchException exception) {
        com.socialmedia.exception.ErrorType errorType = com.socialmedia.exception.ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    /**
     * PathVariable eksik olduğunda fırlatıcak exception
     *
     * @PathVariable --> auth/find-by-id/{id}
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(MissingPathVariableException exception) {
        com.socialmedia.exception.ErrorType errorType = com.socialmedia.exception.ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }

    /**
     * Bir veri tabaninda unique olan bir sütunda aynı değerden birden fazla var ise fırlatılacak hatadır.
     * Yani username property'si veritabanıa unique olarak iaşretlendiyse ve bir değere sahip ise (örn: java8) sahipse
     * bu değerden bir tane daha olmamalıdır. Eğer siz el ile bu değerden bir tane daha eklerseniz veriyi çekmek
     * istediğinizde DataIntegrityViolationException hatası alırsınız.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<ErrorMessage> handlePsqlException(DataIntegrityViolationException exception) {
        com.socialmedia.exception.ErrorType errorType = ErrorType.USERNAME_DUPLICATE;
        return new ResponseEntity<>(createError(errorType, exception), errorType.getHttpStatus());
    }
}
