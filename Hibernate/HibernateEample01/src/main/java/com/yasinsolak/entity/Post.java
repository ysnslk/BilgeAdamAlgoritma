package com.yasinsolak.entity;

/*
    content,
    date,
    user
 */

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date date = new Date();
    private Long userId;

    public Post(String content, Date date, Long userId) {
        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public Post(String content, Long userId) {
        this.userId = userId;
        this.content = content;
    }

    public Post() {

    }


}
