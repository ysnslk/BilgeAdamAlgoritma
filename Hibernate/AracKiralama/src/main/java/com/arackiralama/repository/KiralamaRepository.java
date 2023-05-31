package com.arackiralama.repository;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.Kiralama;
import com.arackiralama.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class KiralamaRepository extends MyFactoryRepository<Kiralama, Long> {
    public KiralamaRepository() {
        super(new Kiralama());
    }

    public List<Kiralama> getBelirtilenTariheKadarOlanKiralamalar(LocalDate date) {
        openSession();
        CriteriaQuery<Kiralama> criteria = getCriteriaBuilder().createQuery(Kiralama.class);
        Root<Kiralama> root = criteria.from(Kiralama.class);
        criteria.select(root);

        criteria.where(getCriteriaBuilder().lessThanOrEqualTo(root.get("kiralamabitis"),date));

        List<Kiralama> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        if (result.isEmpty()) {
            System.out.println("Girilen Tarihe Kadar Yapılan Kiralama Yoktur");
            return null;
        }
        return result;
    }
}