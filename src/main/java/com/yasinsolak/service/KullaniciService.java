package com.yasinsolak.service;

import com.yasinsolak.entity.Kullanici;
import com.yasinsolak.repository.KullaniciRepository;
import com.yasinsolak.utility.MyFactoryService;

import java.util.Optional;

public class KullaniciService extends MyFactoryService<KullaniciRepository, Kullanici, Long>{
    
    public KullaniciService(){
        super( new KullaniciRepository());
    }

    public Optional<Kullanici> findByUsernameAndPass(String username, String password) {
        return getRepository().findByUsernameAndPass(username,password);
    }
}
