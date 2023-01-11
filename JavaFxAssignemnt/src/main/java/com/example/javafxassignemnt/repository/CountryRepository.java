package com.example.javafxassignemnt.repository;

import com.example.javafxassignemnt.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {
    Optional<Country> findAllById(long id);
}