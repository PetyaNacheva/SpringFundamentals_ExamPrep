package com.example.shopingapp.service.impl;

import com.example.shopingapp.models.entity.Category;
import com.example.shopingapp.models.entity.enums.CategoryEnum;
import com.example.shopingapp.repositories.CategoryRepository;
import com.example.shopingapp.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategory() {
    if(categoryRepository.count()==0){
        Category shirt = new Category(CategoryEnum.SHIRT);
        Category denim= new Category(CategoryEnum.DENIM);
        Category shorts= new Category(CategoryEnum.SHORTS);
        Category jacket= new  Category(CategoryEnum.JACKET);
        categoryRepository.save(shorts);
        categoryRepository.save(shirt);
        categoryRepository.save(denim);
        categoryRepository.save(jacket);
    }
    }

    @Override
    public Category findByName(CategoryEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
