package com.arackiralama.controller;

import com.arackiralama.entity.Musteri;
import com.arackiralama.service.MusteriService;

import java.util.Optional;

public class MusteriController {

    private MusteriService musteriService;

    public MusteriController(){
        this.musteriService = new MusteriService();
    }

    public void save(Musteri musteri) {
        musteriService.save(musteri);
    }

    public Optional<Musteri> findById(long musteriId) {
        return musteriService.findById(musteriId);
    }

    public Musteri update(Musteri musteri) {
        return musteriService.update(musteri);
    }
}