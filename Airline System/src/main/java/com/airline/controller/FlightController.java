package com.airline.controller;

import com.airline.entity.Flight;
import com.airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;


    public void insertPayment(Flight flight) throws SQLException {
        //JdbcDao jdbcDao = new JdbcDao();
        flightRepository.save(flight);
    }
    public void updatePayment(Flight flight){
        flightRepository.save(flight);
    }
    public List<Flight> findAll(){
        return flightRepository.findAll();
    }
    public Optional<Flight> findById(int id){
        return flightRepository.findById(id);
    }
}
