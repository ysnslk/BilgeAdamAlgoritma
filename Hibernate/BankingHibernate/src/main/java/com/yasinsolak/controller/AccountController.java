package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Account;
import com.yasinsolak.entity.User;
import com.yasinsolak.service.AccountService;

public class AccountController {

    private AccountService accountService;
    public AccountController(){
        this.accountService = new AccountService();
    }
    public void createAccount(User user) {
        Account account = new Account(user);
        accountService.save(account);
        System.out.println("Hesap başarı ile oluşturuldu");
    }

    public void transferMoney(User user) {
        String fromAccountNo = BAUtils.readString("Hesabı seç");
        String accountNo = BAUtils.readString("Kime Para göndermek istiyosunuz ? Hesap No :");
        double amount  = BAUtils.readDouble("Ne kadar göndermek istiyosunuz ?");
        accountService.transferMoney(fromAccountNo,accountNo,amount,user);
    }
}
