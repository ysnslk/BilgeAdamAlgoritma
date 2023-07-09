package com.yemeksepeti.demo.service;

import com.yemeksepeti.demo.dto.request.ActiveRequestDto;
import com.yemeksepeti.demo.dto.request.CustomerLoginRequestDto;
import com.yemeksepeti.demo.repository.entity.Customer;
import com.yemeksepeti.demo.repository.ICustomerRepository;
import com.yemeksepeti.demo.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {

    private ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Boolean login(CustomerLoginRequestDto dto) {
        Optional<Customer> customerOptional = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (customerOptional.isEmpty()) {
            throw new RuntimeException("Kullanıcı bulunamadı");
        }
        if(!customerOptional.get().getStatus().equals("1")){
            throw new RuntimeException("Hesabınız Aktif Değil");
        }
        return true;
    }

    public Boolean activeStatus(ActiveRequestDto dto) {
        Optional<Customer> optionalCustomer = findById(dto.getId());
        if (optionalCustomer.isEmpty()){
            throw new RuntimeException("Kullanıcı Bulunmadı");
        }
        if (optionalCustomer.get().getStatus().equals("1")){
            throw new RuntimeException("Aktivasyon Kodu zaten girilmiş");
        }
        if (dto.getActivationCode().equals(optionalCustomer.get().getActivationCode())){
            optionalCustomer.get().setStatus("1");
            update(optionalCustomer.get());
            return true;
        }else{
            throw new RuntimeException("Hatalı Kod");
        }
    }

}
