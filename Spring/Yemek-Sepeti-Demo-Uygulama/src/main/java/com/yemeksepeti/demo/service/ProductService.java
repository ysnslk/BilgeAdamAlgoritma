package com.yemeksepeti.demo.service;

import com.yemeksepeti.demo.repository.IProductRepository;
import com.yemeksepeti.demo.repository.entity.Product;
import com.yemeksepeti.demo.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product,Long> {
    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Product createProduct(Product product){
        return repository.save(product);
    }
}
