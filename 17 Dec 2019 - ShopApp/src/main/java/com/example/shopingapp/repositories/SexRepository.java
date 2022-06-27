package com.example.shopingapp.repositories;

import com.example.shopingapp.models.entity.Sex;
import com.example.shopingapp.models.entity.enums.SexEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SexRepository extends JpaRepository<Sex, Long> {
    Optional<Sex> findByName(SexEnum name);
}
