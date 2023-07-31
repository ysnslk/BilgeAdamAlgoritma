package com.yasin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class Test06_TekrarEdenTetler {
    @RepeatedTest(100)
    void getPostListTekrar() {
        System.out.println("Postlar Listelendi");
    }

    @RepeatedTest(value = 50, name = "denemeler {currentRepetition} . Deneme / {totalRepetitions} TEST")
    @DisplayName("Post Listeleme Testi")
    void getPostListTekrar2() {
        System.out.println("Postlar Listelendi");
    }
}
