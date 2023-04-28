package com.yasinsolak.repository;

import com.yasinsolak.entity.ProductDetails;
import com.yasinsolak.util.MyFactoryRepository;

public class ProductDetailRepository extends MyFactoryRepository<ProductDetails,Long> {

    public ProductDetailRepository(){
        super(new ProductDetails());
    }
}
