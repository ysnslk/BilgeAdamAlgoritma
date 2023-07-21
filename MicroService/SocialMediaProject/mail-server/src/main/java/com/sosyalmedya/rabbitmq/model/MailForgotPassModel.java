package com.sosyalmedya.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailForgotPassModel implements Serializable {
    String username;
    String email;
    String randomPassword;
}
