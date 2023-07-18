package com.socialmedia.rabbitmq.consumer;

import com.socialmedia.rabbitmq.model.AuthForgotPassModel;
import com.socialmedia.rabbitmq.model.AuthRegisterModel;
import com.socialmedia.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutForgotPassConsumer {

    private final UserProfileService userProfileService;

    @RabbitListener(queues = ("user-forgot-pass-queue"))
    public void newForgotPass(AuthForgotPassModel model) {
        userProfileService.forgotPasswordWithRabbitMq(model);
    }
}
