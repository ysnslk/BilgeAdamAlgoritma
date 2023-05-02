package com.yasinsolak.repository;

import com.yasinsolak.entity.YarismaKatilim;
import com.yasinsolak.utility.MyFactoryRepository;

public class YarismaKatilimRepository extends MyFactoryRepository<YarismaKatilim,Long> {
    public YarismaKatilimRepository(){
        super(new YarismaKatilim());
    }
}
