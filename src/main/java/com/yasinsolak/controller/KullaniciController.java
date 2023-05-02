package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Kullanici;
import com.yasinsolak.entity.Yarisma;
import com.yasinsolak.service.KullaniciService;

import java.util.List;
import java.util.Optional;

public class KullaniciController {
    
    private KullaniciService kullaniciService;
    
    public KullaniciController(){
        this.kullaniciService = new KullaniciService();
    }
    
    public void kullaniciKaydet(){
        String kullaniciAdi = BAUtils.readString("Kullanıcı Adınızı Giriniz : ");
        String sifre = BAUtils.readString("Şifrenizi Giriniz");
        String ad = BAUtils.readString("İsminizi Giriniz");
        String soyad = BAUtils.readString("Soyadınızı Giriniz");
        String email = BAUtils.readString("Mailinizi Giriniz");
        Kullanici kullanici = new Kullanici(kullaniciAdi, sifre,ad,soyad,email);
        kullaniciService.save(kullanici);
    }

    public Kullanici login() {
        String username = BAUtils.readString("Kullanıcı Adınız : ");
        String password = BAUtils.readString("Şifreniz : ");
        Optional<Kullanici> userOptional =  kullaniciService.findByUsernameAndPass(username,password);
        return userOptional.get();
    }

    public void KullaniciListele(){
        List<Kullanici> kullaniciList = kullaniciService.findAll();
        kullaniciList.forEach(System.out::println);
    }

    public Long getById(String ad){
        Kullanici kullanici = new Kullanici();
        kullanici.setName(ad);
        List<Kullanici> kullaniciList = kullaniciService.findByEntity(kullanici);
        Long id = kullaniciList.get(0).getId();
        return id;
    }
}
