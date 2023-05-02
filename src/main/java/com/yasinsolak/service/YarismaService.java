package com.yasinsolak.service;

import com.yasinsolak.entity.Yarisma;
import com.yasinsolak.repository.YarismaRepository;
import com.yasinsolak.utility.MyFactoryService;

public class YarismaService extends MyFactoryService<YarismaRepository, Yarisma,Long> {
    public YarismaService(){
        super (new YarismaRepository());
    }
}
