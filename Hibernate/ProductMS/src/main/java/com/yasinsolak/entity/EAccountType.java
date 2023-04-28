package com.yasinsolak.entity;

public enum EAccountType {
    NORMAL(10),
    GOLD(50),
    PREMIUM(100);

    private final double indirimMiktari;
    EAccountType(double indirimMiktari){
        this.indirimMiktari = indirimMiktari;
    }
    public double getIndirimMiktari(){
        return null;
    }
}
