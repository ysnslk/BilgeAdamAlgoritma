package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Kullanici;
import com.yasinsolak.entity.Yarisma;
import com.yasinsolak.entity.YarismaKatilim;
import com.yasinsolak.service.YarismaKatilimService;
import com.yasinsolak.service.YarismaService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

public class YarismaKatilController {

    private YarismaKatilimService yarismaKatilimService;
    private YarismaService yarismaService;
    public YarismaKatilController(){
        this.yarismaService = new YarismaService();
        this.yarismaKatilimService = new YarismaKatilimService();
    }

    public void YarismayaKatil(Kullanici kullanici) {
        List<Yarisma> yarismaList = yarismaService.findAll();
        yarismaList.forEach(System.out::println);
        Long id = Long.parseLong(BAUtils.readString("Katılmak istediğiniz IDyi giriniz"));
        Yarisma  yarisma = new Yarisma();
        yarisma.setId(id);
        YarismaKatilim yarismaKatilim = new YarismaKatilim(yarisma,kullanici);
        yarismaKatilimService.save(yarismaKatilim);
        System.out.println("Katılım gerçekleşti");
    }

    public void KatilanlarıListele() {
        List<Yarisma> yarismaList = yarismaService.findAll();
        yarismaList.forEach(System.out::println);
        Long id = Long.parseLong(BAUtils.readString("Katılmak istediğiniz IDyi giriniz"));
        Optional<YarismaKatilim> yarismaKatilimList = yarismaKatilimService.findById(id);
        System.out.println("Katılımcılar : " + yarismaKatilimList.get().getKullanici().getUsername());
    }

    public Long getById(Long id){
        YarismaKatilim yarismaKatilim = new YarismaKatilim();
        Kullanici kullanici = new Kullanici();
        kullanici.setId(id);
        yarismaKatilim.setKullanici(kullanici);
        List<YarismaKatilim> yarismaKatilimList =yarismaKatilimService.findByEntity(yarismaKatilim);
        Long user_id = yarismaKatilimList.get(0).getId();
        return user_id;
    }
}
