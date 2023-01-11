package com.airline.repository;

import com.airline.entity.Userflight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserflightRepository extends JpaRepository<Userflight, Integer> {
}