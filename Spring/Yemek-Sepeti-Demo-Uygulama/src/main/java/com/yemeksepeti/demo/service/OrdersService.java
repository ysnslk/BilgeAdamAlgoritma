package com.yemeksepeti.demo.service;

import com.yemeksepeti.demo.repository.IOrdersRepository;
import com.yemeksepeti.demo.repository.entity.Orders;
import com.yemeksepeti.demo.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService extends ServiceManager<Orders,Long> {
    private final IOrdersRepository repository;

    public OrdersService(IOrdersRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Orders creteOrder(Orders orders){
        return repository.save(orders);
    }

    public Optional<Orders> findOrdersByRestaurantId(Long resraurantId) {
        return repository.findOrdersByRestaurantId(resraurantId);
    }

    public Optional<Orders> findOrdersByCustomerId(Long customerId) {
        return repository.findOrdersByCustomerId(customerId);
    }
}
