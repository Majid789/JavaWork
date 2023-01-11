package com.example.javafxassignemnt.repository;

import com.example.javafxassignemnt.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TownRepository extends JpaRepository<Town, Integer>, JpaSpecificationExecutor<Town> {
    Optional<Town> findAllById(long id);

}