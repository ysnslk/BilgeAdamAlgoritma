package com.arackiralama.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "araclar")
public class Arac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marka;
    private String model;
    private LocalDate yil;
    @Enumerated(EnumType.STRING)
    private VitesTipi vitesTipi;
    @Enumerated(EnumType.STRING)
    private YakitTuru yakitTuru;
    private double fiyat;
    private boolean durum;

}