package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Category;
import com.yasinsolak.entity.Product;
import com.yasinsolak.service.CategoryService;
import com.yasinsolak.service.ProductService;

import java.util.Optional;

public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    public ProductController(){
        this.productService = new ProductService();
        this.categoryService = new CategoryService();
    }
    public void save(){
        String productName = BAUtils.readString("Product Name : ");
        double price = BAUtils.readDouble("Product Price : ");
        int stock = BAUtils.readInt("Product Stock : ");
        long categoryId = BAUtils.readInt("Category Id : ");
        Optional<Category> optionalCategory = categoryService.findById(categoryId);
        if(optionalCategory.isPresent()) {
            Product product = new Product();
            product.setName(productName);
            product.setPrice(price);
            product.setStock(stock);
            product.setCategory(optionalCategory.get());
            productService.save(product);
        }else {
            System.out.println("Böyle bir kategori bulunmamaktardır...!");
        }

    }
}
