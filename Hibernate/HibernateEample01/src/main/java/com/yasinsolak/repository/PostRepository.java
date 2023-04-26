package com.yasinsolak.repository;

import com.yasinsolak.entity.Post;
import com.yasinsolak.utility.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PostRepository {

    //12- Her bir kullanıcı kaç post atmış.

    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public PostRepository() {
        entityManager = HibernateUtils.getSessionFactory().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public List<Tuple> usersPostCount(){
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        criteriaQuery.multiselect(root.get("userId"),criteriaBuilder.count(root)).groupBy(root.get("userId"));

        List<Tuple> list = entityManager.createQuery(criteriaQuery).getResultList();
        list.forEach(x->{
            System.out.println("userId: " + x.get(0) + "--" + "count: " + x.get(1));
        });
        return list;
    }
}
