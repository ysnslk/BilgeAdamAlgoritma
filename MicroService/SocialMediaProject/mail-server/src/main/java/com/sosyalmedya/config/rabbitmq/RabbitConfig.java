package com.sosyalmedya.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    //Mail Sender Consumer
    private final String mailRegisterQueue = "mail-register-queue";
    @Bean
    Queue mailRegisterQueue(){
        return new Queue(mailRegisterQueue);
    }

    //Mail Send Forgot Pass
    private final String mailForgotPassQueue = "mail-forgot-pass-queue";
    @Bean
    Queue mailForgotPassQueue(){
        return new Queue(mailForgotPassQueue);
    }

}
