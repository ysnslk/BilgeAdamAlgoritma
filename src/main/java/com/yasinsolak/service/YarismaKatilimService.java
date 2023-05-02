package com.yasinsolak.service;

import com.yasinsolak.entity.YarismaKatilim;
import com.yasinsolak.repository.YarismaKatilimRepository;
import com.yasinsolak.utility.MyFactoryService;

public class YarismaKatilimService extends MyFactoryService<YarismaKatilimRepository, YarismaKatilim,Long> {
    public YarismaKatilimService(){
        super(new YarismaKatilimRepository());
    }
}
