package com.example.javafxassignemnt.repository;

import com.example.javafxassignemnt.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Integer>, JpaSpecificationExecutor<State> {
    Optional<State> findAllById(long id);

}