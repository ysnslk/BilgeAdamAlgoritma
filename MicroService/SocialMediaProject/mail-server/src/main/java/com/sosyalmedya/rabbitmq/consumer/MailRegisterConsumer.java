package com.sosyalmedya.rabbitmq.consumer;


import com.sosyalmedya.rabbitmq.model.MailRegisterModel;
import com.sosyalmedya.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailRegisterConsumer {

    private final MailSenderService mailSenderService;

    @RabbitListener(queues = "mail-register-queue")
    public String sendRegisterUsersInfo(MailRegisterModel mailRegisterModel){
        System.out.println(mailRegisterModel);
        mailSenderService.sendRegisterUsersInfo(mailRegisterModel);
        return mailRegisterModel.toString();
    }

}
