package com.yasin;

/**
 * import static -> Assertions için kullanılarak sürekli bu sınıfı çağırmadan
 * kullanmamızı sağlar.
 */

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Test03_AssertUsing {
    private final static Islemler islem = new Islemler();

    @Test
    void standartAssert() {
        int result = islem.topla(45, 99);
        assertEquals(144, result);
        /**
         * Hata durumlarında açıklama yapmak önemlidir. Çünkü sizin kodunuzu ya da
         * test kodlarınızı başkaları okuyacak ya da değiştirecektir. Bu nedenle oluşan
         * hata hakkında detaylı bilgi vermek önemlidir.
         */
        assertEquals(144, result, "Toplama islemi basarisiz");
        assertTrue(result == 144);
        assertTrue(result == 145, "Toplama islemi basarisiz.");

    }

    @Test
    void groupAssert() {
        assertAll("Toplu Toplama işlemi",
                () -> assertEquals(5, islem.topla(2, 3)),
                () -> assertEquals(10, islem.topla(5, 5)),
                () -> assertEquals(15, islem.topla(5, 10))
        );
    }

    @Test
    void exceptionTest() {
        assertThrows(ArithmeticException.class, () -> islem.bolme(10, 0));
    }

    @Test
    void exceptionTestMessage() {
        Exception exception = assertThrows(ArithmeticException.class, () -> islem.bolme(10, 0));
        assertEquals("Bolen 0 olamaz", exception.getMessage());
    }

    @Test
    void timeoutTest() {
        assertTimeout(Duration.ofMillis(400), () -> {
          long start = System.currentTimeMillis();
            System.out.println("Islem Basladi");
            // Bu bekleme alanı bir kodun çalışma süresini simüle etmek için yazılmıştırç
            Thread.sleep(380);
            System.out.println("Islem Bitti");
            long end = System.currentTimeMillis();
            System.out.println("Islem suresi"+(end-start+"ms"));
        });
    }
}
