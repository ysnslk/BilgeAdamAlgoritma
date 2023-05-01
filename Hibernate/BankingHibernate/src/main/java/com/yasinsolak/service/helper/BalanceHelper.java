package com.yasinsolak.service.helper;

import com.yasinsolak.entity.Account;

public class BalanceHelper {
    public static boolean accountBalanceIsSmaller(Account account,double amount){
        if (account.getBalance() < amount){
            System.out.println("Bakiye Yetersiz ");
            return false;
        }
            return true;
    }
}
