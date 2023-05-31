package com.arackiralama.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "musteriler")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;
    private String soyad;
    private String adres;
    private String telefon;
    private String email;

    @OneToMany(mappedBy = "musteri",fetch = FetchType.EAGER)
    private List<Kiralama> kiraladigiAraclar;

    @Override
    public String toString() {
        return "Musteri{" +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", adres='" + adres + '\'';
    }
}