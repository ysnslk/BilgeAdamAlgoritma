package com.yemeksepeti.demo.controller;

import com.yemeksepeti.demo.dto.request.ActiveRequestDto;
import com.yemeksepeti.demo.dto.request.CustomerLoginRequestDto;
import com.yemeksepeti.demo.dto.request.CustomerSaveRequestDto;
import com.yemeksepeti.demo.mapper.ICustomerMapper;
import com.yemeksepeti.demo.repository.entity.Customer;
import com.yemeksepeti.demo.service.CustomerService;
import com.yemeksepeti.demo.utility.CodeGenerator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public Customer createCustomer(@RequestBody @Valid CustomerSaveRequestDto dto){
        Customer customer = ICustomerMapper.INSTANCE.customerFromDto(dto);
        customer.setActivationCode(CodeGenerator.generatecode());
        return customerService.save(customer);
    }

    @PostMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
    @PostMapping("/login")
    public ResponseEntity<Boolean> login (@RequestBody CustomerLoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }

    @PostMapping("/activestatus")
    public ResponseEntity<Boolean> activeStatus (@RequestBody ActiveRequestDto dto){
        return ResponseEntity.ok(customerService.activeStatus(dto));
    }
}
