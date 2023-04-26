package com.yasinsolak.repository;

import com.yasinsolak.entity.Product;
import com.yasinsolak.util.MyFactoryRepository;

public class ProductRepository extends MyFactoryRepository<Product,Long> {
    public ProductRepository(){
        super(new Product());
    }
}
