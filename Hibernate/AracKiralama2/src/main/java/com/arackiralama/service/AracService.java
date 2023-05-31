package com.arackiralama.service;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.YakitTuru;
import com.arackiralama.repository.AracRepository;
import com.arackiralama.util.MyFactoryService;

import java.time.LocalDate;
import java.util.List;

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
}