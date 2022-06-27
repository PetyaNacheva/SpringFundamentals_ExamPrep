package com.example.shopingapp.service;

import com.example.shopingapp.models.entity.Sex;
import com.example.shopingapp.models.entity.enums.SexEnum;

public interface SexEnumService {
    void initSex();

    Sex findByName(SexEnum sex);
}
