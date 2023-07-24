package com.yasin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IslemlerTest {
    @Test
    public void toplaTest(){
        Islemler islemler = new Islemler();
        int result = islemler.topla(5,12);
        /**
         * Reslut değerinin 17 olmasını bekleriz.
         */
        Assertions.assertEquals(17,result);
    }
    @Test
    public void bolmeTest(){
        Islemler islemler = new Islemler();
        double result = islemler.bolme(10,2);
        Assertions.assertEquals(5,result);
    }
    @Test
    public void bolmeTestException(){
        Islemler islemler = new Islemler();
        Assertions.assertThrows(ArithmeticException.class,()->islemler.bolme(10,0));
    }
}
