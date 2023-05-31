package com.arackiralama.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "kiralamalar")
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate kiralamaBaslangic;
    private LocalDate kiralamabitis;
    private double toplamTutar;
    @ManyToOne
    @JoinColumn(name = "arac_id",referencedColumnName = "id")
    private Arac arac;
    @ManyToOne
    @JoinColumn(name = "musteri_id",referencedColumnName = "id")
    private Musteri musteri;

}