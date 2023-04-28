package com.yasinsolak.service;

import com.yasinsolak.entity.ProductDetails;
import com.yasinsolak.repository.ProductDetailRepository;
import com.yasinsolak.util.MyFactoryService;

public class ProductDetailService extends MyFactoryService<ProductDetailRepository, ProductDetails,Long> {
    public ProductDetailService(){
        super(new ProductDetailRepository());
    }
}
