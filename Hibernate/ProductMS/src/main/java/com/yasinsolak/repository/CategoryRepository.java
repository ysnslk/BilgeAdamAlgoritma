package com.yasinsolak.repository;

import com.yasinsolak.entity.Category;
import com.yasinsolak.util.MyFactoryRepository;

public class CategoryRepository extends MyFactoryRepository<Category,Long> {
    public CategoryRepository(){
        super(new Category());
    }
}
