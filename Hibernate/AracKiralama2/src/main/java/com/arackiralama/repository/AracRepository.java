package com.arackiralama.repository;

import com.arackiralama.entity.Arac;
import com.arackiralama.entity.YakitTuru;
import com.arackiralama.util.MyFactoryRepository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class AracRepository extends MyFactoryRepository<Arac, Long> {

    public AracRepository() {
        super(new Arac());
    }

    public List<Arac> findByMarkaAndModel(String marka, String model) {
        openSession();
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("marka"), marka),
                getCriteriaBuilder().equal(root.get("model"), model));
        List<Arac> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        if (result.isEmpty()) {
            System.out.println("Araç Bulunamadı");
            return null;
        }
        return result;
    }
    public Arac findByMarkaAndModelHQL(String marka, String model) {
        String query = "FROM Arac a where a.marka = :marka AND a.model = :model";

        TypedQuery<Arac> typedQuery = getEntityManager().createQuery(query, Arac.class);
        typedQuery.setParameter("marka",marka);
        typedQuery.setParameter("model",model);

        return typedQuery.getSingleResult();
    }
    public List<Arac> findAllByDurumHQL(boolean durum) {
        String query = "FROM Arac a where a.durum = :durum";
        TypedQuery<Arac> typedQuery = getEntityManager().createQuery(query, Arac.class);
        typedQuery.setParameter("durum",durum);
        return typedQuery.getResultList();
    }

    public List<Arac> findAllByDurum(boolean durum) {
        openSession();
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("durum"), durum));
        List<Arac> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        if (result.isEmpty()) {
            System.out.println("Kiralanacak Araç Yok");
            return null;
        }
        return result;
    }

    public List<Arac> getAraclarByYakitTuru(YakitTuru yakitTuru) {
        openSession();
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("yakitTuru"), yakitTuru));
        List<Arac> result = getEntityManager().createQuery(criteria).getResultList();
        closeSession();
        if (result.isEmpty()) {
            System.out.println("Bu Yakıt Turunde araç bulunmamaktadır");
            return null;
        }
        return result;
    }

    //Hibernate Query Language
}
