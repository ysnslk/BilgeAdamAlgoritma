package com.movieapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/deneme")
@RequiredArgsConstructor
public class DenemeController {

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deneme");
        String kullaniciAdi = "Kullanıcı Adı:";
        String sifre = "Şifre:";
        String eposta = "m@gmail.com";
        String resim = "profil.png";
        modelAndView.addObject("kullaniciAdi",kullaniciAdi);
        modelAndView.addObject("psw",sifre);
        modelAndView.addObject("img",resim);
        modelAndView.addObject("email",eposta);
        return modelAndView;
    }

    @PostMapping("/doLogin")
    public ModelAndView login(String txtKullaniciAdi, String txtSifre){
        ModelAndView modelAndView = new ModelAndView();
        if(txtKullaniciAdi.equals("ali") && txtSifre.equals("123")){
            modelAndView.setViewName("detaySayfasi");
        }else{
            modelAndView.setViewName("hataSayfasi");
        }
        return modelAndView;
    }

}
