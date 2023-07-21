package com.socialmedia.rabbitmq.producer;

import com.socialmedia.rabbitmq.model.MailForgotPassModel;
import com.socialmedia.rabbitmq.model.UserForgotPassModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailForgotPassProducer {
    private String exchange = "exchange-auth";
    private final String mailForgotPassBinding = "mail-forgot-pass-binding";
    private final RabbitTemplate rabbitTemplate;
    public void sendMailForgotPass(MailForgotPassModel mailForgotPassModel) {
        rabbitTemplate.convertAndSend(exchange,
                mailForgotPassBinding,
                mailForgotPassModel);
    }
}
