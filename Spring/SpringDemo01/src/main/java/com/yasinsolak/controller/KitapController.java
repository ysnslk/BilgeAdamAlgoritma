package com.yasinsolak.controller;

import com.yasinsolak.entity.Kitap;
import com.yasinsolak.service.KitapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kitap")
public class KitapController {

    private final KitapService kitapService;

    public KitapController(KitapService kitapService){
        this.kitapService = kitapService;
    }

    @GetMapping("/savekitap")
    public void saveKitap(String baslik,String yazarismi,int sayfasayisi){
        Kitap kitap = Kitap.builder()
                .baslik(baslik)
                .yazarismi(yazarismi)
                .sayfasayisi(sayfasayisi)
                .build();
        kitapService.saveKitap(kitap);
    }

    @GetMapping("/findall")
    public List<Kitap> findall(){
       return kitapService.findAll();
    }

    @GetMapping("/findbybaslik")
    public Kitap findByBaslik(String baslik){
        return  kitapService.findByBaslik(baslik);
    }
    @GetMapping("/findallbysayfasayisi")
    public List<Kitap> findAllBySayfasayisi(int sayfaSayisi){
        return kitapService.findAllBySayfasayisi(sayfaSayisi);
    }
}
