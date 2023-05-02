/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yasinsolak.repository;

import com.yasinsolak.entity.Kullanici;
import com.yasinsolak.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;


public class KullaniciRepository extends MyFactoryRepository<Kullanici, Long>{
    
    public KullaniciRepository(){
        super (new Kullanici());
    }

    public Optional<Kullanici> findByUsernameAndPass(String username, String password) {
        openSession();
        CriteriaQuery<Kullanici> criteria = (CriteriaQuery<Kullanici>) getCriteriaBuilder().createQuery(Kullanici.class);
        Root<Kullanici> root = (Root<Kullanici>) criteria.from(Kullanici.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("username"), username));
        criteria.where(getCriteriaBuilder().equal(root.get("password"), password));
        List<Kullanici> result = getEntityManager().createQuery(criteria).getResultList();
        if (result.isEmpty())
            return Optional.empty();
        closeSession();
        return Optional.of(result.get(0));
    }


}
