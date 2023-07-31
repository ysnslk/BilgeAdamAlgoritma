package com.yasin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Bu Sinif Ozel bir ozelligi test etmek icin olusturuldu.")
public class Test02_DisplayName {

    @Test
    @DisplayName("\uD83D\uDE31")
    void test01() {
        System.out.println("Test01");
    }

    @Nested
    class nestedClassOrnek {
        @Test
        @DisplayName("Bu test metodu")
        void deneme() {
            System.out.println("Deneme");
        }
    }
}
