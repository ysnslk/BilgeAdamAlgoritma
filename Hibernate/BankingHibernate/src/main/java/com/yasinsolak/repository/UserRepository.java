package com.yasinsolak.repository;

import com.yasinsolak.entity.User;
import com.yasinsolak.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class UserRepository extends MyFactoryRepository<User,Long> {
    public UserRepository(){
        super(new User());
    }

    public Optional<User> findByEmail(String email) {
        openSession();
        CriteriaQuery<User> criteria = (CriteriaQuery<User>) getCriteriaBuilder().createQuery(User.class);
        Root<User> root = (Root<User>) criteria.from(User.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("email"), email));
        List<User> result = getEntityManager().createQuery(criteria).getResultList();
        if (result.isEmpty())
            return Optional.empty();
        closeSession();
        return Optional.of(result.get(0));
    }
}
