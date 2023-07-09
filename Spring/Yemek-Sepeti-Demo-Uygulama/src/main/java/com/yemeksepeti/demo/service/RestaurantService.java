package com.yemeksepeti.demo.service;

import com.yemeksepeti.demo.repository.IRestaurantRepository;
import com.yemeksepeti.demo.repository.entity.Restaurant;
import com.yemeksepeti.demo.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends ServiceManager<Restaurant,Long> {
    private final IRestaurantRepository repository;
    public RestaurantService(IRestaurantRepository repository) {
        super(repository);
        this.repository =repository;
    }

    public Restaurant createRestaurant (Restaurant restaurant){
        return repository.save(restaurant);
    }
}
