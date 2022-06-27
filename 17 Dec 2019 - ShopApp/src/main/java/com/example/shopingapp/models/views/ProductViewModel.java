package com.example.shopingapp.models.views;

import com.example.shopingapp.models.entity.Category;
import com.example.shopingapp.models.entity.Sex;

import java.math.BigDecimal;

public class ProductViewModel {
    private Long id;
    private String name;
    private Sex sex;
    private Category category;
    private BigDecimal price;

    public ProductViewModel() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
}
