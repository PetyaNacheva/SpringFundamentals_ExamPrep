package com.example.shopingapp.models.views;

import com.example.shopingapp.models.entity.Category;
import com.example.shopingapp.models.entity.Sex;

import java.math.BigDecimal;

public class ProductDetailsViewModel {
    private Long id;
    private String name;
    private Sex sex;
    private Category category;
    private BigDecimal price;
    private String description;

    public ProductDetailsViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
