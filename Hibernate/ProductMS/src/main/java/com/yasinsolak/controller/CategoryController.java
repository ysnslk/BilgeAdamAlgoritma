package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Category;
import com.yasinsolak.service.CategoryService;

public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(){
        this.categoryService = new CategoryService();
    }

    public void save(){
        String categoryName = BAUtils.readString("Category Name : ");
        Category category = new Category();
        category.setName(categoryName);
        categoryService.save(category);
    }
}
