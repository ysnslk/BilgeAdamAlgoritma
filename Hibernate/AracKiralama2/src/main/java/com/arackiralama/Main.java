package com.arackiralama;

import com.arackiralama.controller.AracController;
import com.arackiralama.controller.KiralamaController;
import com.arackiralama.controller.MusteriController;
import com.arackiralama.entity.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private AracController aracController = new AracController();
    private MusteriController musteriController = new MusteriController();
    private KiralamaController kiralamaController = new KiralamaController();

    public static void main(String[] args) {
        Main main = new Main();
        main.anaMenu();
    }

    private void anaMenu() {
        int input = 0;
        do {
            System.out.println("1- Araç Ekle");
            System.out.println("2- Musteri Ekle");
            System.out.println("3- Araç Ara");
            System.out.println("4- Kiralama Yap");
            System.out.println("5- Raporlama Menusu");
            input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    aracEkle();
                    break;
                case 2:
                    kisiEkle();
                    break;
                case 3:
                    aracAra();
                    break;
                case 4:
                    kiralamaYap();
                    break;
                case 5:
                    raporlamaMenusu();
                    break;
            }
        } while (input != 0);
    }
    private void raporlamaMenusu() {
        int input = 0;
        do {
            System.out.println("1- Şuan Kirada Olan Araçlar");
            System.out.println("2- Boşta Olan Araçlar");
            System.out.println("3- Herhangi bir müşterinin kiralıdıgı araçlar");
            System.out.println("4- YakitTurune Göre arama yapalım");
            System.out.println("5- Girilen tarihe kadar olan kiralamaları getirelim");
            input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    kiradaOlanlarAraclar();
                    break;
                case 2:
                    bostaOlanAraclar();
                    break;
                case 3:
                    musteriyeGoreAraclar();
                    break;
                case 4:
                    yakitTuruneGoreAramaYap();
                    break;
                case 5:
                    getBelirtilenTariheKadarOlanKiralamalar();
                    break;
            }
        } while (input != 0);
    }

    private void getBelirtilenTariheKadarOlanKiralamalar() {
        System.out.println("Araç Yılını girin");
        int yil = Integer.parseInt(scanner.nextLine());

        System.out.println("Aracın Ayını girin");
        int ay = Integer.parseInt(scanner.nextLine());

        System.out.println("Aracın Günün Girin");
        int gun = Integer.parseInt(scanner.nextLine());

        LocalDate date = LocalDate.of(yil,ay,gun);
        kiralamaController.getBelirtilenTariheKadarOlanKiralamalar(date)
                .forEach(kiralama-> System.out.println("Son Günü: "+kiralama.getKiralamabitis()
                        + "Model: " +kiralama.getArac().getModel()));
    }

    private void yakitTuruneGoreAramaYap() {
        System.out.println("Yakıt Turu girin");
        YakitTuru yakitTuru = YakitTuru.valueOf(scanner.nextLine().toUpperCase());

        System.out.println(aracController.getAraclarByYakitTuru(yakitTuru));
    }

    private void musteriyeGoreAraclar() {
        System.out.println("müşteri ID: ");
        int musteriId = Integer.parseInt(scanner.nextLine());
        Optional<Musteri> optionalMusteri = musteriController.findById(musteriId);
        optionalMusteri.get().getKiraladigiAraclar().forEach(x-> System.out.println(x.getArac()));
    }

    private void bostaOlanAraclar() {
        System.out.println("Boşta Olan Araçlar");
        aracController.findAllByDurum(false).forEach(x-> System.out.println(x.getMarka()));
    }

    private void kiradaOlanlarAraclar() {
        System.out.println("Kirada Olan Araçlar");
        aracController.findAllByDurum(true).forEach(x->System.out.println(x.getMarka()));
    }

    private void kiralamaYap() {
        List<Arac> aracList = aracController.findAllByDurum(false);
        if (aracList != null) {
            aracList.forEach(x -> System.out.println("ID: " + x.getId() + " ---- " + x.getMarka() + " ---- " + x.getModel()));

            System.out.println("Kiralamak istediğiniz aracı belirtin: ");
            long aracId = Long.parseLong(scanner.nextLine());
            Optional<Arac> optionalArac = aracController.findById(aracId);

            System.out.println("ID nizi Girin: ");
            long musteriId = Long.parseLong(scanner.nextLine());
            Optional<Musteri> optionalMusteri = musteriController.findById(musteriId);

            if (optionalArac.isPresent() && optionalMusteri.isPresent()){
                Arac arac = optionalArac.get();
                Musteri musteri = optionalMusteri.get();
                System.out.println("Kaç Gün Kiralamak İstiyorsunuz");
                int days = Integer.parseInt(scanner.nextLine());

                Kiralama kiralama = Kiralama.builder()
                        .kiralamaBaslangic(LocalDate.now())
                        .kiralamabitis(LocalDate.now().plusDays(days))
                        .arac(arac)
                        .musteri(musteri)
                        .build();
                kiralamaController.save(kiralama);
                musteri.getKiraladigiAraclar().add(kiralama);
                arac.setDurum(true);
                aracController.update(arac);
                musteriController.update(musteri);
                musteri.getKiraladigiAraclar().forEach(x -> System.out.println(x.getArac().getMarka()));
                //kiralamaController.findAll().forEach(x-> System.out.println(x.getId() + " " + x.getArac()));

            }
        }
    }

    private void aracAra() {
        System.out.println("Marka: ");
        String marka = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        aracController.findByMarkaAndModel(marka, model).forEach(x -> System.out.println(x.getMarka() + "---" + x.getModel()));
    }

    private void kisiEkle() {
        System.out.println("Ad: ");
        String ad = scanner.nextLine();
        System.out.println("SoyAd: ");
        String soyad = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();

        Musteri musteri = Musteri.builder()
                .ad(ad)
                .soyad(soyad)
                .email(email)
                .build();
        musteriController.save(musteri);
    }

    private void aracEkle() {
        System.out.println("Araç Markasını girin");
        String marka = scanner.nextLine();
        System.out.println("Araç Modelini girin");
        String model = scanner.nextLine();

        System.out.println("Araç Yılını girin");
        int yil = Integer.parseInt(scanner.nextLine());

        System.out.println("Aracın Ayını girin");
        int ay = Integer.parseInt(scanner.nextLine());

        System.out.println("Aracın Günün Girin");
        int gun = Integer.parseInt(scanner.nextLine());

        LocalDate date = LocalDate.of(yil,ay,gun);

        System.out.println("Vites Tipi girin");
        VitesTipi vitesTipi = VitesTipi.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Yakıt Turu girin");
        YakitTuru yakitTuru = YakitTuru.valueOf(scanner.nextLine().toUpperCase());

        Arac arac = Arac.builder()
                .marka(marka)
                .model(model)
                .yil(date)
                .vitesTipi(vitesTipi)
                .yakitTuru(yakitTuru)
                .build();
        aracController.saveArac(arac);
    }
}