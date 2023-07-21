package com.sosyalmedya.controller;

import com.sosyalmedya.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

@RequestMapping("/mail")
public class MailController {
    private final MailSenderService mailSenderService;

    @GetMapping("")
    public void test(){

         mailSenderService.sendMailTest();
    }

}
