package com.socialmedia.rabbitmq.producer;

import com.socialmedia.rabbitmq.model.UserForgotPassModel;
import com.socialmedia.rabbitmq.model.UserRegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserForgotPassProducer {
    private String exchange = "exchange-auth";
    private final String userForotPassBinding = "user-forgot-pass-binding";
    private final RabbitTemplate rabbitTemplate;

    public void sendForgotPass(UserForgotPassModel userForgotPassModel) {
        rabbitTemplate.convertAndSend(exchange,
                userForotPassBinding,
                userForgotPassModel);
    }
}
