package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Product;
import com.yasinsolak.entity.ProductDetails;
import com.yasinsolak.service.ProductDetailService;
import com.yasinsolak.service.ProductService;

import java.util.Optional;

public class ProductDetailController {

    private ProductDetailService productDetailService;
    private ProductService productService;

    public ProductDetailController(){
        this.productDetailService = new ProductDetailService();
        this.productService = new ProductService();
    }

    public void makeCommentAndPuan(){
        long productId = BAUtils.readInt("Yorum yapmak istediğiniz ürün: ");
        String comment  = BAUtils.readString("Yorumunuz : ");
        int puan = BAUtils.readInt("Puanınız : ");

        Optional<Product> optionalProduct = productService.findById(productId);
        if(optionalProduct.isEmpty()){
            System.out.println("Böyle bir product bulunamadı");
        }else{
            ProductDetails productDetail = new ProductDetails();
            productDetail.setComment(comment);
            productDetail.setPuan(puan);

            //optionalProduct.get().getProductDetails().add(productDetail);
            productDetail.setProduct(optionalProduct.get());
            productDetailService.save(productDetail);
        }

    }

    public void findEvaluteByProductId(){
        long productId = BAUtils.readInt("Ürün Idsi : ");
        Optional<Product> optionalProduct = productService.findById(productId);
        if (optionalProduct.isEmpty()){
            System.out.println("Böyle bir product bulunamadı");
        }else{
            System.out.println(optionalProduct.get().getName());
            optionalProduct.get().getProductDetails().forEach(x-> System.out.println("Yapılan Yorum : "+x.getComment()+" Puan : "+x.getPuan()));
        }

    }
}
