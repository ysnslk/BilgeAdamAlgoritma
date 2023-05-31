package com.arackiralama.controller;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.Kiralama;
import com.arackiralama.service.AracService;
import com.arackiralama.service.KiralamaService;

import java.time.LocalDate;
import java.util.List;

public class KiralamaController {

    private KiralamaService kiralamaService;
    public KiralamaController(){
        this.kiralamaService = new KiralamaService();
    }

    public void save(Kiralama kiralama) {
        kiralamaService.save(kiralama);
    }

    public List<Kiralama> getBelirtilenTariheKadarOlanKiralamalar(LocalDate date) {
        return kiralamaService.getBelirtilenTariheKadarOlanKiralamalar(date);
    }

    public List<Kiralama> findAll() {
        return kiralamaService.findAll();
    }
}