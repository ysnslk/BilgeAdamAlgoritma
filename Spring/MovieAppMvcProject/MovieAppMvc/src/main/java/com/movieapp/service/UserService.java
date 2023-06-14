package com.movieapp.service;


import com.movieapp.dto.request.UserLoginRequestDto;
import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserLoginResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.User;
import com.movieapp.mapper.IUserMapper;
import com.movieapp.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;
    public UserRegisterResponseDto save(UserRegisterRequestDto dto) {
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Bu email Zaten Kullanılıyor");
        }else {
            if(!dto.getPassword().equals(dto.getRePassword())){
                throw new RuntimeException("Passwordler uyuşmuyor");
            }
            User user = IUserMapper.INSTANCE.toUser(dto);
            userRepository.save(user);
            return IUserMapper.INSTANCE.toRegisterResponseDto(user);
        }
    }

    public UserLoginResponseDto login(UserLoginRequestDto dto){
        Optional<User> optionalUser = userRepository.findByEmailIgnoreCaseAndPassword(dto.getEmail(),dto.getPassword());
        if(optionalUser.isEmpty()){
            throw new RuntimeException("Girdiğiniz bilgiler uyuşmamaktadır.");
        }else{
            return IUserMapper.INSTANCE.toLoginResponseDto(optionalUser.get());
        }
    }
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }
}