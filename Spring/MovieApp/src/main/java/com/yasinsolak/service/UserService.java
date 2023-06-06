package com.yasinsolak.service;

import com.yasinsolak.entity.EUserType;
import com.yasinsolak.entity.User;
import com.yasinsolak.repository.IUserRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;


    public User createUser(String name, String surname, String email, String phone, String password, String userType) {
        EUserType userType1 = null;
        User user;
        try {
            userType1 = EUserType.valueOf(userType);
            user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .userType(userType1)
                    .build();
        }catch (Exception ex){
            System.out.println("Böyle bir userType bulunamadı");
            user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .phone(phone)
                    .password(password)
                    .build();
        }
        return userRepository.save(user);
    }

    public List<User> findAll() {
       return userRepository.findAll();
    }

    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public List<User> findAllOrderByName(){
        return userRepository.findAllByOrderByName();
    }
    public List<User> findAllByNameLike(String name){
        return userRepository.findAllByNameLike(name);
    }
    public List<User> findByEmailContainingIgnoreCase(String email){
        return userRepository.findByEmailContainingIgnoreCase(email);
    }
    public List<User> findAllByEmailEndsWith(String email){
        return userRepository.findByEmailContainingIgnoreCase(email);
    }
    public List<User> findAllByEmailEndingWith(String email){
        return userRepository.findByEmailContainingIgnoreCase(email);
    }
    public Boolean existsByEmailAndPassword(String email,String password){
        return userRepository.existsByEmailAndPassword(email,password);
    }
    public Optional<User> findByEmailIgnoreCaseAndPassword(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmailIgnoreCaseAndPassword(email,password);
        if (optionalUser.isPresent()){
            return optionalUser;
        }else {
            throw new RuntimeException("Böyle bir kullanıcı yok");
        }
    }
    public List<User> passwordLongerThen(int length){
        return userRepository.passwordLongerThen(length);
    }
}
