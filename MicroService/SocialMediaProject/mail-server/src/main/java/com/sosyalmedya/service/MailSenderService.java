package com.sosyalmedya.service;

import com.sosyalmedya.rabbitmq.model.MailForgotPassModel;
import com.sosyalmedya.rabbitmq.model.MailRegisterModel;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final JavaMailSender javaMailSender;

    public void sendRegisterUsersInfo(MailRegisterModel mailRegisterModel) {
        /**
         * Alternatif Kapsamlı
         * MimeMessage mimeMessage = new MimeMessage();
         * MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
         * MimeMailMessage mimeMailMessage = new MimeMailMessage(mimeMessageHelper);
         */
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${spring.mail.username}"); // Sunucu olarak kullanılacak mail
        mailMessage.setTo(mailRegisterModel.getEmail()); // Kullanıcının girmiş olduğu mail
        mailMessage.setSubject("DOĞRULAMA KODU");
        mailMessage.setText(
                "<h1>Tebrikler,</h1>"
                        + "\n <h3> Sisteme başarı ile kayıt oldunuz. Giriş ve onay bilgileriniz aşağıdaki gibidir. </h3>"
                        + "\n <h3> Kullanıcı Adı : </h3>" + mailRegisterModel.getUsername()
                        + "\n <h3> Şifre :  </h3>" + mailRegisterModel.getPassword()
                        + "\n <h3> Doğrulama Kodu :  </h3>" + mailRegisterModel.getActivateCode()
        );
        javaMailSender.send(mailMessage);
    }
    public void sendMailForgotPassInfo(MailForgotPassModel mailForgotPassModel) {
        /**
         * Alternatif Kapsamlı
         * MimeMessage mimeMessage = new MimeMessage();
         * MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
         * MimeMailMessage mimeMailMessage = new MimeMailMessage(mimeMessageHelper);
         */
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${spring.mail.username}"); // Sunucu olarak kullanılacak mail
        mailMessage.setTo(mailForgotPassModel.getEmail()); // Kullanıcının girmiş olduğu mail
        mailMessage.setSubject("Yeni Şifre Bilgileri");
        mailMessage.setText(
                "<h1>Tebrikler,</h1>"
                        + "\n <h3> Yeni Şifre bilgileriniz aşağıdaki gibidir. </h3>"
                        + "\n <h3> Şifre :  </h3>" + mailForgotPassModel.getRandomPassword()
        );
        javaMailSender.send(mailMessage);
    }

    public void sendMailTest() {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${spring.mail.username}"); // Sunucu olarak kullanılacak mail
        mailMessage.setTo("yasin.solak.26@gmail.com"); // Kullanıcının girmiş olduğu mail
        mailMessage.setSubject("Yeni Şifre Bilgileri");
        mailMessage.setText(
                "<h1>Tebrikler,</h1> Controller Çalıştı."
        );
        javaMailSender.send(mailMessage);
    }


}
