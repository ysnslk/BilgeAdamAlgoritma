package com.yasinsolak.firstexample;



public class CustomerService {

    private MessageRepository messageRepository;
    private MailRepository mailRepository;


    public CustomerService(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public void CustomerService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }


    public CustomerService(){
        this.messageRepository = new MessageRepository();
        this.mailRepository = new MailRepository();
    }

    public void sendMessage(){
        messageRepository.sendMessage();
    }

    public void sendMail(){
        mailRepository.sendMail();
    }



}
