package com.yasinsolak.controller;

import com.yasinsolak.dto.request.UserLoginRequestDto;
import com.yasinsolak.dto.request.UserRegisterRequestDto;
import com.yasinsolak.dto.response.UserFindAllReponseDto;
import com.yasinsolak.dto.response.UserLoginResponseDto;
import com.yasinsolak.dto.response.UserRegisterResponseDto;
import com.yasinsolak.entity.User;
import com.yasinsolak.exception.ErrorType;
import com.yasinsolak.exception.MovieAppException;
import com.yasinsolak.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //register metotu yazalım parametre olarak UserRegisterDto alsın
    //kullanıcı register olurken name surname email password versin
    //UserRegisterDto Oluşturalım
    //bize User dönsün

    //id, name, surname, email, userType
    //UserRegisterResponseDto
    //PostMapping

    //findAll --> UserFindAllResponseDto
    //id, name, email, surname, phone, usertype, favMovies, genres

    //login metodu yazalım post request dto alsın bize dto dönsün

    @PostMapping("/logindto")
    public UserLoginResponseDto loginUser(@RequestBody UserLoginRequestDto dto){
        return userService.loginDto(dto);
    }
    @PostMapping("/loginnormal")
    public User loginUserNormal(String email,String password){
        return userService.loginNormal(email,password);
    }
    @PostMapping("/register")
    public UserRegisterResponseDto createUser(UserRegisterRequestDto dto){
        return userService.register(dto);
    }
    @PostMapping("/register2")
    public ResponseEntity<UserRegisterResponseDto> createUser2(@RequestBody UserRegisterRequestDto dto){
        try{
            UserRegisterResponseDto responseDto = userService.register2(dto);
            return new ResponseEntity(responseDto, HttpStatus.CREATED);
        }catch (Exception ex){
            throw new MovieAppException(ErrorType.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/create")
    public User createUser(String name, String surname, String email, String phone, String password, String userType){
        return userService.createUser(name,surname,email,phone,password,userType);
    }
    @GetMapping("/findalldto")
    public List<UserFindAllReponseDto> findAlldto(){
        return userService.findAlldto();
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
