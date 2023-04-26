package com.yasinsolak.controller;

import com.yasinsolak.entity.Post;
import com.yasinsolak.repository.PostRepository;
import com.yasinsolak.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class PostController {

    public static void main(String[] args) {
        //createPost();

        PostRepository postRepository = new PostRepository();
        postRepository.usersPostCount();
    }

    public static void createPost(){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Post post = new Post("içerik1",new Date(), 1L);
        Post post2 = new Post("içerik2",new Date(), 2L);
        Post post3 = new Post("içerik3",new Date(), 1L);

        Post post4 = new Post("içerik4", 2L);
        Post post5 = new Post("içerik5", 3L);

        session.save(post);
        session.save(post2);
        session.save(post3);

        session.save(post4);
        session.save(post5);
        transaction.commit();

        //transaction.rollback();
        session.close();
    }
}
