package com.yasinsolak.repository;

import com.yasinsolak.entity.Yarisma;
import com.yasinsolak.utility.MyFactoryRepository;

public class YarismaRepository extends MyFactoryRepository<Yarisma,Long> {
    public YarismaRepository(){
        super(new Yarisma());
    }
}
