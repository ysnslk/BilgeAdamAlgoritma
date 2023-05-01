package com.yasinsolak.service;

import com.yasinsolak.entity.Account;
import com.yasinsolak.entity.User;
import com.yasinsolak.repository.AccountRepository;
import com.yasinsolak.service.helper.BalanceHelper;
import com.yasinsolak.utility.MyFactoryService;

import java.util.Optional;

public class AccountService extends MyFactoryService<AccountRepository, Account,Long> {

    public AccountService(){
        super(new AccountRepository());
    }

    public void transferMoney(String fromAccountNo, String accountNo, double amount, User user) {
        user.getAccounts().forEach(x-> System.out.println(x.getHesapNo()));
        Optional<Account> optionalAccount =  getRepository().findAccountByAccountNo(fromAccountNo);
        Optional<Account> optionalAccount2 =  getRepository().findAccountByAccountNo(accountNo);
        /*
        if(!BalanceHelper.accountBalanceIsSmaller(optionalAccount.get(),amount)){
            System.out.println("Bakiye Yetersiz");
        }
         */
        if (optionalAccount.isEmpty() || optionalAccount2.isEmpty()){
            System.out.println("Hesap Nolarını kontrol et");
        }else {
            optionalAccount.get().setBalance( optionalAccount.get().getBalance() - amount);
            optionalAccount2.get().setBalance( optionalAccount2.get().getBalance() + amount);
            getRepository().update(optionalAccount.get());
            getRepository().update(optionalAccount2.get());
            System.out.println("Transfer Başarılı...!!");
        }

    }
}
