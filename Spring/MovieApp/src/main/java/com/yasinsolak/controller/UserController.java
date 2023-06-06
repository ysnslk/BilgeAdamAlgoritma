package com.yasinsolak.controller;

import com.yasinsolak.entity.EUserType;
import com.yasinsolak.entity.User;
import com.yasinsolak.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/create")
    public User createUser(String name, String surname, String email, String phone, String password, String userType){
        return userService.createUser(name,surname,email,phone,password,userType);
    }
    @GetMapping("/findall")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/findallorderbyname")
    public ResponseEntity<List<User>> findAllOrderByName(){
        return ResponseEntity.ok(userService.findAllOrderByName());
    }
    @GetMapping("/findallnamelike")
    public ResponseEntity<List<User>> findAllByNameLike(String name){
        return ResponseEntity.ok(userService.findAllByNameLike("%"+name+"%"));
    }
    @GetMapping("/findallemailcontaining")
    public ResponseEntity<List<User>> findByEmailContainingIgnoreCase(String value){
        return ResponseEntity.ok(userService.findByEmailContainingIgnoreCase(value));
    }
    @GetMapping("/endingwith")
    public ResponseEntity<List<User>> findAllByEmailEndsWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndsWith(value));
    }
    @GetMapping("/endswith")
    public ResponseEntity<List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok(userService.findAllByEmailEndingWith(value));
    }
    @GetMapping("/login")
    public ResponseEntity <Boolean> existsByEmailAndPassword(String email,String password){
        return ResponseEntity.ok(userService.existsByEmailAndPassword(email,password));
    }
    @GetMapping("/login2")
    public ResponseEntity <Optional<User>> findByEmailIgnoreCaseAndPassword(String email, String password){
        return ResponseEntity.ok(userService.findByEmailIgnoreCaseAndPassword(email,password));
    }
    @GetMapping("/passwordthenmax")
    public ResponseEntity<List<User>> passwordLongerThen(int length){
        return ResponseEntity.ok(userService.passwordLongerThen(length));
    }

}
