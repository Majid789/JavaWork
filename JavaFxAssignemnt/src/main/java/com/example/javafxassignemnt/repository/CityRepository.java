package com.example.javafxassignemnt.repository;

import com.example.javafxassignemnt.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {
    Optional<City> findAllById(long id);
}