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
public class MailRegisterModel implements Serializable {
    private String username;
    private String email;
    private String password;
    private String activateCode;
}
