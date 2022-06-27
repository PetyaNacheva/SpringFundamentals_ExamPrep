package com.example.shopingapp.models.entity;

import com.example.shopingapp.models.entity.enums.SexEnum;

import javax.persistence.*;

@Entity
@Table(name = "sex")
public class Sex extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SexEnum name;

    public Sex() {
    }

    public Sex(SexEnum name) {
        this.name = name;
    }

    public SexEnum getName() {
        return name;
    }

    public void setName(SexEnum name) {
        this.name = name;
    }
}
