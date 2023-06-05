package com.yasinsolak.service;

import com.yasinsolak.entity.Kitap;
import com.yasinsolak.repository.IKitapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KitapService {

    private final IKitapRepository kitapRepository;

    public KitapService(IKitapRepository kitapRepository){
        this.kitapRepository = kitapRepository;
    }

    public void saveKitap(Kitap kitap){

        kitapRepository.save(kitap);
    }

    public List<Kitap> findAll(){
      return  kitapRepository.findAll();
    }

    public Kitap findByBaslik(String baslik){
        return  kitapRepository.findByBaslik(baslik);
    }

    public List<Kitap> findAllBySayfasayisi(int sayfaSayisi){
        if(sayfaSayisi<0){
            throw new RuntimeException("Sayfa sayısı sıfırdan küçük olamaz");
        }else{
            return kitapRepository.findAllBySayfasayisi(sayfaSayisi);
        }
    }

    public Kitap findByKitapOpt(String baslik){
        Optional<Kitap> optionalKitap = kitapRepository.findOptionalByBaslik(baslik);
        if(optionalKitap.isPresent()){
            return optionalKitap.get();
        }else{
            throw new RuntimeException("Kitap Bulunamadı.");
        }
    }
}
