package com.yasinsolak.service;

import com.yasinsolak.entity.Product;
import com.yasinsolak.repository.ProductRepository;
import com.yasinsolak.util.MyFactoryService;

public class ProductService extends MyFactoryService<ProductRepository, Product,Long> {
    public ProductService(){
        super(new ProductRepository());
    }
}
