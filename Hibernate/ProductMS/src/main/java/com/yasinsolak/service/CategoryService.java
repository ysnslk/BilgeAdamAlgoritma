package com.yasinsolak.service;

import com.yasinsolak.entity.Category;
import com.yasinsolak.repository.CategoryRepository;
import com.yasinsolak.util.MyFactoryService;

public class CategoryService extends MyFactoryService<CategoryRepository,Category,Long> {
    public CategoryService(){
        super(new CategoryRepository());
    }
}
