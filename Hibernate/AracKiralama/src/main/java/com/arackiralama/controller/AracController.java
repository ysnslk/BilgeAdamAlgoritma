package com.arackiralama.controller;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.YakitTuru;
import com.arackiralama.service.AracService;

import java.util.List;
import java.util.Optional;

public class AracController {

    private AracService aracService;
    public AracController(){
        this.aracService = new AracService();
    }
    public void saveArac(Arac arac) {
        aracService.save(arac);
    }

    public List<Arac> findByMarkaAndModel(String marka, String model) {
        return aracService.findByMarkaAndModel(marka, model);
    }

    public List<Arac> findAllByDurum(boolean durum) {
        return aracService.findAllByDurum(durum);
    }

    public Optional<Arac> findById(long aracId) {
        return aracService.findById(aracId);
    }

    public Arac update(Arac arac) {
        return aracService.update(arac);
    }

    public List<Arac> getAraclarByYakitTuru(YakitTuru yakitTuru) {
        return aracService.getAraclarByYakitTuru(yakitTuru);
    }
}