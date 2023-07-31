package com.yasin;

public class Islemler {
    public int topla(int a,int b){
        return a+b;
    }

    public double bolme(double a,double b){
        if (b==0)
            throw new ArithmeticException("Bolen 0 olamaz");
        return a/b;
    }
}
