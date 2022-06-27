package com.example.shopingapp.models.binding;

import com.example.shopingapp.models.entity.enums.CategoryEnum;
import com.example.shopingapp.models.entity.enums.SexEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ProductBindingModel {
    private Long id;
    @NotBlank(message = "product name is required")
    @Size(min = 3, max = 20, message = "product name must be between 3 and 20 chars")
    private String name;
    @NotBlank(message = "description is required")
    @Size(min = 3, max = 20, message = "product name must be between 3 and 20 chars")
    private String description;
    @DecimalMin(value = "0", message = "price must be positive number")
    private BigDecimal price;
    @NotNull(message = "category is required")
    private CategoryEnum category;
    @NotNull(message = "sex is required")
    private SexEnum sex;

    public ProductBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
