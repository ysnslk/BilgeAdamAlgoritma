package com.yasinsolak.app;


import com.yasinsolak.controller.KullaniciController;
import com.yasinsolak.controller.YarismaController;
import com.yasinsolak.controller.YarismaKatilController;
import com.yasinsolak.entity.Kullanici;
import java.util.HashMap;

public class Menu {
private KullaniciController kullaniciController;
private YarismaController yarismaController;

private YarismaKatilController yarismaKatilController;

    public Menu(){
       this.kullaniciController = new KullaniciController();
       this.yarismaController = new YarismaController();
       this.yarismaKatilController  = new YarismaKatilController();
    }
    public void menu(){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Kullanıcı Kaydet");
        menuItems.put(2,"Kullanıcı Girişi");
        menuItems.put(3,"Kullanıcıları Göster");
        menuItems.put(4,"Yarışmacıları Göster (Herhangi bir yarışmacı)");
        menuItems.put(5,"Herhangi bir kullanıcının açtığı yarışmalar");
        menuItems.put(6,"Kullanıcının Katıldığı Yarışmaları Göster");

        while(true){
            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1:
                    kullaniciController.kullaniciKaydet();
                    break;
                case 2:

                    Kullanici kullanici = kullaniciController.login();
                    accountManagement(kullanici);
                    break;
                case 3:

                    kullaniciController.KullaniciListele();
                    break;
                case 4:
                    yarismaKatilController.KatilanlarıListele();
                    break;
                case 5:
                    yarismaController.KullanicininActigiYarismalar();
                    break;
                case 6:
                    yarismaController.KullaniciniKatildigiYarismalar();
                    break;
            }
        }
    }

    public void accountManagement(Kullanici kullanici){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Yarışma Oluştur");
        menuItems.put(2,"Yarışmaya Katıl");
        menuItems.put(3,"Kullanıcının Açtığı Yarışmalar");
        menuItems.put(4,"Katılanları Listele");
        while (true){

            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1:
                    yarismaController.YarismaOlustur(kullanici);
                    System.out.println("Oluşturuldu");
                    break;
                case 2:
                    yarismaKatilController.YarismayaKatil(kullanici);
                    break;
                case 3:
                    yarismaController.KullanicininActigiYarismalar();
                    break;
                case 4:
                    yarismaKatilController.KatilanlarıListele();
                    break;
            }
        }
    }
}
