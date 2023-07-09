package com.yemeksepeti.demo.controller;

import com.yemeksepeti.demo.dto.request.ProductSaveRequestDto;
import com.yemeksepeti.demo.mapper.IProductMapper;
import com.yemeksepeti.demo.repository.entity.Product;
import com.yemeksepeti.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/save")
    public Product createProduct(@RequestBody @Valid ProductSaveRequestDto dto){
        Product product = IProductMapper.INSTANCE.productFromDto(dto);
        return productService.save(product);
    }
}
