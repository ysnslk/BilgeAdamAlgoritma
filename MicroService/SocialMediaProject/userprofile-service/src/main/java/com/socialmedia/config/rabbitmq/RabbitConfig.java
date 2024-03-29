package com.socialmedia.config.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    //Auth register consumer
    String authRegisterQueue = "user-register-queue";

    @Bean
    Queue authRegisterQueue(){
        return new Queue(authRegisterQueue);
    }
    //Auth forgot pass consumer
    private final String authForotPassQueue = "user-forgot-pass-queue";
    @Bean
    Queue authForgotPassQueue(){
        return new Queue(authForotPassQueue);
    }
}
