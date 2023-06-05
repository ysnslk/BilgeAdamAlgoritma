package com.yasinsolak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Bir metod yazalım .Bu metod bize bir String değer dönsün
 * rest controller olarak webden istek atalım.
 *
 * 2- İsim listesi döndürelim
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/request")
    public String stringDeger(){
        return "String bir değer dönsün";
    }

    @GetMapping("/requestList")
    public List<String> ListDeger(){
        List<String> isim = new ArrayList<>();
        isim.add("Ali");
        isim.add("Ahmet");
        isim.add("Zeynep");
        return isim;
    }
}
