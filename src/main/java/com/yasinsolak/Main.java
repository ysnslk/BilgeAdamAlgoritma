package com.yasinsolak;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.app.Menu;
import com.yasinsolak.entity.Kullanici;
import com.yasinsolak.entity.Yarisma;
import com.yasinsolak.entity.YarismaKatilim;
import com.yasinsolak.service.KullaniciService;
import com.yasinsolak.service.YarismaKatilimService;
import com.yasinsolak.service.YarismaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    private KullaniciService kullaniciService;
    private YarismaService yarismaService;
    private YarismaKatilimService yarismaKatilimService;

    public Main(){
        this.kullaniciService = new KullaniciService();
        this.yarismaService = new YarismaService();
        this.yarismaKatilimService = new YarismaKatilimService();
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.kullaniciEKle();
        main.YarismaEKle();
        main.YarismaKatilimEkle();
        Menu menu = new Menu();
        menu.menu();
    }



    public  void kullaniciEKle(){
        try{


        Kullanici kullanici1 = new Kullanici("Mehmet123", "123123","mehmet","kaya","mehmetkaya@gmail.com");
        kullaniciService.save(kullanici1);

        Kullanici kullanici2 = new Kullanici("Ayse123", "123123","ayse","pestel","aysepestel@gmail.com");
        kullaniciService.save(kullanici2);

        Kullanici kullanici3 = new Kullanici("Mahmet123", "123123","mahmut","tuncer","mahmuttuncer@gmail.com");
        kullaniciService.save(kullanici3);

        Kullanici kullanici4 = new Kullanici("Ali123", "123123","ali","veli","aliveli@gmail.com");
        kullaniciService.save(kullanici4);

        Kullanici kullanici5 = new Kullanici("Fatma123", "123123","fatma","kaya","fatmakaya@gmail.com");
        kullaniciService.save(kullanici5);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }

    public  void YarismaEKle(){
       try {
           String tarih = "05-05-2023";
           DateTimeFormatter formattertarih = DateTimeFormatter.ofPattern("dd-MM-yyyy");
           LocalDate dateTimeTarih= LocalDate.parse(tarih, formattertarih);

           Yarisma yarisma1 = new Yarisma("Oyun-1","1000TL",dateTimeTarih,dateTimeTarih,5);
           Kullanici kullanici1 = new Kullanici();
           kullanici1.setId(1L);
           yarisma1.setKullanici(kullanici1);
           yarismaService.save(yarisma1);

           Yarisma yarisma2 = new Yarisma("Oyun-2","2000TL",dateTimeTarih,dateTimeTarih,15);
           Kullanici kullanici2 = new Kullanici();
           kullanici2.setId(2L);
           yarisma2.setKullanici(kullanici2);
           yarismaService.save(yarisma2);

           Yarisma yarisma3 = new Yarisma("Oyun-3","3000TL",dateTimeTarih,dateTimeTarih,25);
           Kullanici kullanici3 = new Kullanici();
           kullanici3.setId(3L);
           yarisma3.setKullanici(kullanici3);
           yarismaService.save(yarisma3);

           Yarisma yarisma4 = new Yarisma("Oyun-4","4000TL",dateTimeTarih,dateTimeTarih,35);
           Kullanici kullanici4 = new Kullanici();
           kullanici4.setId(4L);
           yarisma4.setKullanici(kullanici4);
           yarismaService.save(yarisma4);

           Yarisma yarisma5 = new Yarisma("Oyun-5","5000TL",dateTimeTarih,dateTimeTarih,45);
           Kullanici kullanici5 = new Kullanici();
           kullanici5.setId(5L);
           yarisma5.setKullanici(kullanici5);
           yarismaService.save(yarisma5);
       }
       catch (Exception ex){
           System.out.println(ex.toString());
       }
    }

    public void YarismaKatilimEkle(){
        YarismaKatilim yarismaKatilim1 = new YarismaKatilim();
        Kullanici kullanici1 = new Kullanici();
        kullanici1.setId(1L);
        Yarisma yarisma1 = new Yarisma();
        yarisma1.setId(1L);
        yarismaKatilim1.setKullanici(kullanici1);
        yarismaKatilim1.setYarisma(yarisma1);


        YarismaKatilim yarismaKatilim2 = new YarismaKatilim();
        Kullanici kullanici2 = new Kullanici();
        kullanici2.setId(2L);
        Yarisma yarisma2 = new Yarisma();
        yarisma2.setId(2L);
        yarismaKatilim2.setKullanici(kullanici2);
        yarismaKatilim2.setYarisma(yarisma2);

        YarismaKatilim yarismaKatilim3 = new YarismaKatilim();
        Kullanici kullanici3 = new Kullanici();
        kullanici3.setId(3L);
        Yarisma yarisma3 = new Yarisma();
        yarisma3.setId(3L);
        yarismaKatilim3.setKullanici(kullanici3);
        yarismaKatilim3.setYarisma(yarisma3);

        YarismaKatilim yarismaKatilim4 = new YarismaKatilim();
        Kullanici kullanici4 = new Kullanici();
        kullanici4.setId(4L);
        Yarisma yarisma4 = new Yarisma();
        yarisma4.setId(4L);
        yarismaKatilim4.setKullanici(kullanici4);
        yarismaKatilim4.setYarisma(yarisma4);

        YarismaKatilim yarismaKatilim5 = new YarismaKatilim();
        Kullanici kullanici5 = new Kullanici();
        kullanici5.setId(5L);
        Yarisma yarisma5 = new Yarisma();
        yarisma5.setId(5L);
        yarismaKatilim5.setKullanici(kullanici5);
        yarismaKatilim5.setYarisma(yarisma5);

        yarismaKatilimService.save(yarismaKatilim1);
        yarismaKatilimService.save(yarismaKatilim2);
        yarismaKatilimService.save(yarismaKatilim3);
        yarismaKatilimService.save(yarismaKatilim4);
        yarismaKatilimService.save(yarismaKatilim5);
    }
}