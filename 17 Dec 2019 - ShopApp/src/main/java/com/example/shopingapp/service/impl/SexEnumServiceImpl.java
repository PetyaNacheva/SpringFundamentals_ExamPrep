package com.example.shopingapp.service.impl;

import com.example.shopingapp.models.entity.Sex;
import com.example.shopingapp.models.entity.enums.SexEnum;
import com.example.shopingapp.repositories.SexRepository;
import com.example.shopingapp.service.SexEnumService;
import org.springframework.stereotype.Service;

@Service
public class SexEnumServiceImpl implements SexEnumService {
    private final SexRepository sexRepository;

    public SexEnumServiceImpl(SexRepository sexRepository) {
        this.sexRepository = sexRepository;
    }

    @Override
    public void initSex() {
        if(sexRepository.count()==0){
            Sex male = new Sex(SexEnum.MALE);
            Sex female = new Sex(SexEnum.FEMALE);

            sexRepository.save(male);
            sexRepository.save(female);
        }
    }

    @Override
    public Sex findByName(SexEnum sex) {
        return sexRepository.findByName(sex).orElse(null);
    }
}
