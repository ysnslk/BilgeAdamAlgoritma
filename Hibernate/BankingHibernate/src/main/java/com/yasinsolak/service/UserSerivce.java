package com.yasinsolak.service;

import com.yasinsolak.entity.User;
import com.yasinsolak.repository.UserRepository;
import com.yasinsolak.utility.MyFactoryService;

import java.util.Optional;

public class UserSerivce extends MyFactoryService<UserRepository, User,Long> {
    public UserSerivce(){
        super(new UserRepository());
    }

    public Optional<User> findByEmail(String email) {

        return getRepository().findByEmail(email);
    }
}
