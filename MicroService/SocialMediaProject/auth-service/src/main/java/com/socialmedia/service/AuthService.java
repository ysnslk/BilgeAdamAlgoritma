package com.socialmedia.service;

import com.socialmedia.repository.IAuthRepository;
import com.socialmedia.repository.entity.Auth;
import com.socialmedia.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository repository;

    public AuthService(IAuthRepository repository){
        super(repository);
        this.repository = repository;
    }
}
