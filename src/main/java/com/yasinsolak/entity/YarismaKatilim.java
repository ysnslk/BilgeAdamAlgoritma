package com.yasinsolak.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "yarismakatilim")
public class YarismaKatilim {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="yarisma_id",referencedColumnName = "id")
    private Yarisma yarisma;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="yarismaci_id",referencedColumnName = "id")
    private Kullanici kullanici;
    private LocalDate katilim_tarihi = LocalDate.now();

    public YarismaKatilim(Yarisma yarisma, Kullanici kullanici) {
        this.yarisma = yarisma;
        this.kullanici = kullanici;
    }
}
