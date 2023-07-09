package com.yemeksepeti.demo.controller;

import com.yemeksepeti.demo.repository.entity.Orders;
import com.yemeksepeti.demo.service.OrdersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    @PostMapping("/save")
    public Orders createOrders(@RequestBody @Valid Orders order){
        return ordersService.creteOrder(order);
    }

    @PostMapping("/findById")
    public Optional<Orders> findOrdersByRestaurantId(Long resraurantId){
        return ordersService.findOrdersByRestaurantId(resraurantId);
    }

    @PostMapping("/findAll")
    public List<Orders> findAll(){
        return ordersService.findAll();
    }

    @PostMapping("/findByCustomerId")
    public Optional<Orders> findOrdersByCustomerId(Long customerId){
        return ordersService.findOrdersByCustomerId(customerId);
    }
}
