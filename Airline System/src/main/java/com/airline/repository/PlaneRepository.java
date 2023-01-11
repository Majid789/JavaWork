package com.airline.repository;

import com.airline.entity.Flight;
import com.airline.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlaneRepository extends JpaRepository<Plane, Integer>, JpaSpecificationExecutor<Flight> {
}