package com.example.shopingapp.models.entity;

import com.example.shopingapp.models.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    public Category() {
    }

    public Category(CategoryEnum name) {
        this.name = name;
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }
}
