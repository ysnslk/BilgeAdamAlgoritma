package com.yasinsolak.service;

import com.yasinsolak.entity.Customer;
import com.yasinsolak.entity.EAccountType;
import com.yasinsolak.repository.CustomerRepository;
import com.yasinsolak.util.MyFactoryService;

import java.util.Optional;

public class CustomerService extends MyFactoryService<CustomerRepository, Customer,Long> {
    public CustomerService(){
        super(new CustomerRepository());
    }

    public Optional<Customer> findByUdentity(String identity){
        return getRepository().findByIdentity(identity);
    }

    public void changeAccountType(Customer customer, String accountType) {

        EAccountType accountType1 = EAccountType.valueOf(accountType);
        if (accountType1 == EAccountType.GOLD) {
            customer.setAccountType(EAccountType.GOLD);
            update(customer);
        }else if (accountType1 == EAccountType.PREMIUM){
            customer.setAccountType(EAccountType.PREMIUM);
            update(customer);
        }
    }
}
