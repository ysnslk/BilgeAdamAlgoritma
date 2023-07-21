package com.socialmedia.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    /**
     * Bu rabbitmq configuration sınıfı producer veya consumer işlemleri için gerekli alt yapıyı oluşturmayı sağlar.
     * Producer işlemi(bu serviste bir kuyruk üret ve verileri bu kuyruk üzerinden gönder) yapılacağında exchange, queue ve bindingKey
     * gibi değişkenlere ihtiyaç duyulur.
     * Ancak Consumer işlemi yapılacağı zaman yalnızca tüketilecek olan 'queue' oluşturularak kuyruktan gelen veri deserialize edilir.
     */
    private final String exchange = "exchange-auth";
    //User register producer
    private final String userRegisterQueue = "user-register-queue";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.
    private final String userRegisterBinding = "user-register-binding";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.

    @Bean
    DirectExchange authExchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue userRegisterQueue() {
        return new Queue(userRegisterQueue);
    }

    @Bean
    public Binding bindingRegisterUserProfileMethod(final DirectExchange authExchange, final Queue userRegisterQueue) {
        return BindingBuilder.bind(userRegisterQueue)
                .to(authExchange)
                .with(userRegisterBinding);
    }
    //User Forgot Pass producer
    private final String userForotPassQueue = "user-forgot-pass-queue";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.
    private final String userForotPassBinding = "user-forgot-pass-binding";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.
    @Bean
    Queue userForotPassQueue() {
        return new Queue(userForotPassQueue);
    }

    @Bean
    public Binding bindingForgotPassUserProfileMethod(final DirectExchange authExchange, final Queue userForotPassQueue) {
        return BindingBuilder.bind(userForotPassQueue)
                .to(authExchange)
                .with(userForotPassBinding);
    }


    //Send Mail Register
    private String mailRegisterQueue = "mail-register-queue";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.
    private String  mailRegisterBinding = "mail-register-binding";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.
    @Bean
    Queue mailRegisterQueue() {
        return new Queue(mailRegisterQueue);
    }

    @Bean
    public Binding mailRegisterBinding(final DirectExchange authExchange, final Queue mailRegisterQueue) {
        return BindingBuilder.bind(mailRegisterQueue)
                .to(authExchange)
                .with(mailRegisterBinding);
    }

    //Send Mail Forgot Pass
    private final String mailForgotPassQueue = "mail-forgot-pass-queue";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.
    private final String mailForgotPassBinding = "mail-forgot-pass-binding";  //her producer işlemi için yeniden bir değişken oluşturulmalıdır.
    @Bean
    Queue mailForgotPassQueue() {
        return new Queue(mailForgotPassQueue);
    }

    @Bean
    public Binding bindingMailForgotPassUserProfileMethod(final DirectExchange authExchange, final Queue mailForgotPassQueue) {
        return BindingBuilder.bind(mailForgotPassQueue)
                .to(authExchange)
                .with(mailForgotPassBinding);
    }
}
