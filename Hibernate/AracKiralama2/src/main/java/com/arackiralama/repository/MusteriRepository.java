package com.arackiralama.repository;

import com.arackiralama.entity.Musteri;
import com.arackiralama.util.MyFactoryRepository;

public class MusteriRepository extends MyFactoryRepository<Musteri, Long> {

    public MusteriRepository() {
        super(new Musteri());
    }
}