package com.yasinsolak.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TextXml {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerServiceXml customerServiceXml = new CustomerServiceXml(context.getBean("notification",MessageRepository.class));
        customerServiceXml.sendNotification();

        CustomerServiceXml customerServiceXml2 = new CustomerServiceXml(context.getBean("notification",INotification.class));
        customerServiceXml2.sendNotification();
    }
}
