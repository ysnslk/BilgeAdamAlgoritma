package com.yasinsolak.xml;




public class CustomerServiceXml {

    private MessageRepository messageRepository;
    private MailRepository mailRepository;
    private INotification notification;

    public CustomerServiceXml(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public void CustomerServiceXml(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }


    public CustomerServiceXml(){
        this.messageRepository = new MessageRepository();
        this.mailRepository = new MailRepository();
    }

    public void sendMessage(){
        messageRepository.sendMessage();
    }

    public void sendMail(){
        mailRepository.sendMail();
    }


    public CustomerServiceXml(INotification notification){
        this.notification = notification;
    }

    public void sendNotification(){
        notification.sendNotification();
    }
}
