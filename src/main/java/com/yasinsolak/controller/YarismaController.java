package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Kullanici;
import com.yasinsolak.entity.Yarisma;
import com.yasinsolak.service.KullaniciService;
import com.yasinsolak.service.YarismaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class YarismaController {
    private YarismaService yarismaService;
    private KullaniciController kullaniciController;
    private YarismaKatilController yarismaKatilController;
    public YarismaController(){
        this.yarismaService = new YarismaService();
        this.kullaniciController = new KullaniciController();
        this.yarismaKatilController = new YarismaKatilController();

    }

    public void YarismaOlustur(Kullanici kullanici){
        String ad = BAUtils.readString("Yarışma Adı : ");
        String odul = BAUtils.readString("Yarışma Ödülünü Giriniz");
        String baslangicTarihi = BAUtils.readString("Başlangıç Tarihini Giriniz");
        DateTimeFormatter formatterBaslangic = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateTimeBaslangic = LocalDate.parse(baslangicTarihi, formatterBaslangic);
        String bitisTarihi = BAUtils.readString("Bitiş Tarihini Giriniz");
        DateTimeFormatter formatterBitis = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateTimeBitis = LocalDate.parse(bitisTarihi, formatterBitis);
        int maxKatilimci = BAUtils.readInt("Maksimum Katılım Sayısı :");
        Yarisma yarisma = new Yarisma(ad,odul,dateTimeBaslangic,dateTimeBitis,maxKatilimci);
        yarisma.setKullanici(kullanici);
        yarismaService.save(yarisma);


    }


    public void KullanicininActigiYarismalar() {

        String ad = BAUtils.readString("Ad giriniz");
         Long id = kullaniciController.getById(ad);
         Optional<Yarisma> optionalYarisma = yarismaService.findById(id);
        System.out.println("Id : "+optionalYarisma.get().getId() + " Yarışma Adı : "+optionalYarisma.get().getYarisma_ad());
    }

    public void KullaniciniKatildigiYarismalar() {
        Long id = Long.parseLong(BAUtils.readString("Kullanıcı Idsini Girin :"));
       Long user_id = yarismaKatilController.getById(id);
        Optional<Yarisma> optionalYarisma = yarismaService.findById(user_id);
        System.out.println("Id : "+optionalYarisma.get().getId() + " Yarışma Adı : "+optionalYarisma.get().getYarisma_ad());
    }
}
