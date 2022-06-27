package com.example.shopingapp.init;

import com.example.shopingapp.service.CategoryService;
import com.example.shopingapp.service.SexEnumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements CommandLineRunner {
    private final CategoryService categoryService;
    private final SexEnumService sexEnumService;

    public DbInit(CategoryService categoryService, SexEnumService sexEnumService) {
        this.categoryService = categoryService;
        this.sexEnumService = sexEnumService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initCategory();
        sexEnumService.initSex();
    }
}
