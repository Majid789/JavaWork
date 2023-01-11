package com.airline.controller;

import com.airline.entity.Plane;
import com.airline.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class PlaneController {

    @Autowired
    private PlaneRepository planeRepository;


    public void insertPlane(Plane plane) throws SQLException {
        //JdbcDao jdbcDao = new JdbcDao();
        planeRepository.save(plane);

    }
    public void updatePlane(Plane plane){
        planeRepository.save(plane);
    }
    public List<Plane> findAll(){
        return planeRepository.findAll();
    }
    public Optional<Plane> findById(int id){
        return planeRepository.findById(id);
    }
}
