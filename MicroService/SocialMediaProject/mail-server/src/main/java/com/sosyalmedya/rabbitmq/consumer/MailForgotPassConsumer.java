package com.sosyalmedya.rabbitmq.consumer;

import com.sosyalmedya.rabbitmq.model.MailForgotPassModel;
import com.sosyalmedya.rabbitmq.model.MailRegisterModel;
import com.sosyalmedya.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailForgotPassConsumer {
    private final MailSenderService mailSenderService;
    @RabbitListener(queues = ("mail-forgot-pass-queue"))
    public void sendMailForgotPassInfo(MailForgotPassModel mailForgotPassModel){
        System.out.println(mailForgotPassModel);
        mailSenderService.sendMailForgotPassInfo(mailForgotPassModel);

    }
}
