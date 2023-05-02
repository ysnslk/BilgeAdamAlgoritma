package com.yasinsolak.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

@Table(name = "yarisma")
public class Yarisma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String yarisma_ad;
    private String odul;
    private LocalDate baslangic_tarihi;
     private LocalDate bitis_tarihi;
     @ManyToOne
    @JoinColumn(name="olusturan_id",referencedColumnName = "id")
     private Kullanici kullanici;

     @OneToMany(mappedBy = "yarisma")
     private List<YarismaKatilim> yarismaKatilim;
     private int maxKatilim;

    public Yarisma(String yarisma_ad, String odul, LocalDate baslangic_tarihi, LocalDate bitis_tarihi, Kullanici kullanici, List<YarismaKatilim> yarismaKatilim, int maxKatilim) {
        this.yarisma_ad = yarisma_ad;
        this.odul = odul;
        this.baslangic_tarihi = baslangic_tarihi;
        this.bitis_tarihi = bitis_tarihi;
        this.kullanici = kullanici;
        this.yarismaKatilim = yarismaKatilim;
        this.maxKatilim = maxKatilim;
    }

    public Yarisma(String yarisma_ad, String odul, LocalDate baslangic_tarihi, LocalDate bitis_tarihi,  int maxKatilim) {
        this.yarisma_ad = yarisma_ad;
        this.odul = odul;
        this.baslangic_tarihi = baslangic_tarihi;
        this.bitis_tarihi = bitis_tarihi;
        this.maxKatilim = maxKatilim;
    }

    public Yarisma(String yarisma_ad, String odul,  int maxKatilim) {
        this.yarisma_ad = yarisma_ad;
        this.odul = odul;
        this.maxKatilim = maxKatilim;
    }

    @Override
    public String toString() {
        return "Yarisma{" +
                "id=" + id +
                ", yarisma_ad='" + yarisma_ad + '\'' +
                ", odul='" + odul + '\'' +
                ", baslangic_tarihi=" + baslangic_tarihi +
                ", bitis_tarihi=" + bitis_tarihi +
                ", maxKatilim=" + maxKatilim +
                '}';
    }
}
