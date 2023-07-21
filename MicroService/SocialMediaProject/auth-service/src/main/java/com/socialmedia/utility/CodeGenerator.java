package com.socialmedia.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class CodeGenerator {

    public static String generatecode(){
        String code = UUID.randomUUID().toString();
        String[] data = code.split("-");
        String newCode = "";
        for(String string : data){
            newCode += string.charAt(0);
        }
        return newCode;
    }

}
