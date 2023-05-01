package com.yasinsolak.repository;

import com.yasinsolak.entity.Account;
import com.yasinsolak.entity.User;
import com.yasinsolak.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class AccountRepository extends MyFactoryRepository<Account,Long> {
    public AccountRepository(){
        super(new Account());
    }

    public Optional<Account> findAccountByAccountNo(String accountNo){
        openSession();
        CriteriaQuery<Account> criteria = (CriteriaQuery<Account>) getCriteriaBuilder().createQuery(Account.class);
        Root<Account> root = (Root<Account>) criteria.from(Account.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("hesapNo"), accountNo));
        List<Account> result = getEntityManager().createQuery(criteria).getResultList();
        if (result.isEmpty())
            return Optional.empty();
        closeSession();
        return Optional.of(result.get(0));
    }
}
