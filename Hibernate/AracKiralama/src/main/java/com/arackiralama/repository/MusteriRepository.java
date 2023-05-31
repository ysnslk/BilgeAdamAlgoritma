package com.arackiralama.repository;

import com.arackiralama.entity.Musteri;
import com.arackiralama.utility.MyFactoryRepository;

public class MusteriRepository extends MyFactoryRepository<Musteri, Long> {

    public MusteriRepository() {
        super(new Musteri());
    }
}