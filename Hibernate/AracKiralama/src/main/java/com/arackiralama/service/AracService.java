package com.arackiralama.service;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.Kiralama;
import com.arackiralama.entity.VitesTipi;
import com.arackiralama.entity.YakitTuru;
import com.arackiralama.repository.AracRepository;
import com.arackiralama.utility.MyFactoryService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AracService extends MyFactoryService<AracRepository, Arac, Long> {

    public AracService() {
        super(new AracRepository());
    }


    @Override
    public Arac save(Arac arac){
        if(isValidDate(arac.getYil())){
            return getRepository().save(arac);
        }
        return null;
    }

    private boolean isValidDate(LocalDate date){
        LocalDate currentDate = LocalDate.now();
        return date.isBefore(currentDate) || date.isEqual(currentDate);
    }

    public List<Arac> findByMarkaAndModel(String marka, String model) {
        return getRepository().findByMarkaAndModel(marka,model);
    }

    public List<Arac> findAllByDurum(boolean durum) {
        return getRepository().findAllByDurum(durum);
    }

    public List<Arac> getAraclarByYakitTuru(YakitTuru yakitTuru) {
        return getRepository().getAraclarByYakitTuru(yakitTuru);
    }

        public List<Arac> findByMarkaAndModelStream(String marka,String model){
        List<Arac> aracList = getRepository().findAll().stream()
                .filter(arac -> arac.getMarka().equals(marka) && arac.getModel().equals(model))
                .collect(Collectors.toList());
        return aracList;
        }

        //Yakıt türü ve localdate parametrelerini alsın
        //getYakitYil(LPG,2010,01,01)
        public List<Arac> findByYakitTuruAndYil(YakitTuru yakitTuru,LocalDate date){
            List<Arac> aracList = getRepository().findAll().stream()
                    .filter(arac -> arac.getYakitTuru().equals(yakitTuru) && arac.getYil().isBefore(date))
                    .collect(Collectors.toList());
            return aracList;
        }

        //yili girilen parametreden kucuk olan araçların durumunu false yapalım
        //yil 2010**
    public void makeDurumFalse(int yil){
       getRepository().findAll().stream()
                .filter(arac -> arac.getYil().getYear() < yil)
                .forEach(arac -> {
                    arac.setDurum(false);
                    update(arac);
                });
    }

    //lpg ve manuel arabalar için 1000tl indirim uygula
    public void indiripYap(){
        getRepository().findAll().stream()
                .filter(arac -> arac.getYakitTuru() == YakitTuru.LPG && arac.getVitesTipi() == VitesTipi.MANUEL)
                .forEach(arac -> {
                    arac.setFiyat(arac.getFiyat()-1000);
                    update(arac);
                });
    }

    //Araçların toplam fiyatını bulalım.
    public double toplamFiyat(){
        double toplam = 0;
        return getRepository().findAll().stream().mapToDouble(Arac::getFiyat).sum();
    }

    public Map<Long,YakitTuru> findByYakitTuruAndYil2(YakitTuru yakitTuru,LocalDate date){
        List<Arac> aracList = getRepository().findAll();
        return aracList.stream().
                filter(arac -> arac.getYakitTuru().equals(yakitTuru) && arac.getYil().isBefore(date))
                .collect(Collectors.toMap(Arac::getId,Arac::getYakitTuru));
    }

    public List<Kiralama> yili2015veAdiAliOlan(){
        List<Kiralama> kiralamaList = getRepository().findAll()
                .stream()
                .filter(kiralama -> kiralama.getKiralamaBitis().isBefore(date) && kiralama.getMusteri)
    }
}