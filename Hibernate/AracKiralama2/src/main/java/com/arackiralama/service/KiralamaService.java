package com.arackiralama.service;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.Kiralama;
import com.arackiralama.repository.AracRepository;
import com.arackiralama.repository.KiralamaRepository;
import com.arackiralama.util.MyFactoryService;

import java.time.LocalDate;
import java.util.List;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama, Long> {
    public KiralamaService() {
        super(new KiralamaRepository());
    }

    public List<Kiralama> getBelirtilenTariheKadarOlanKiralamalar(LocalDate date) {
        return getRepository().getBelirtilenTariheKadarOlanKiralamalar(date);
    }
}