package com.arackiralama.service;

import com.arackiralama.entity.Musteri;
import com.arackiralama.repository.MusteriRepository;
import com.arackiralama.utility.MyFactoryService;

import java.util.List;
import java.util.stream.Collectors;

public class MusteriService extends MyFactoryService<MusteriRepository, Musteri, Long> {
    public MusteriService() {
        super(new MusteriRepository());
    }
}