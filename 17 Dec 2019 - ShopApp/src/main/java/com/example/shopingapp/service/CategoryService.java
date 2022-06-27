package com.example.shopingapp.service;

import com.example.shopingapp.models.entity.Category;
import com.example.shopingapp.models.entity.enums.CategoryEnum;

public interface CategoryService {
    void initCategory();

    Category findByName(CategoryEnum category);
}
