package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.City;
import com.example.javafxassignemnt.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    public void insertCity(City city) throws SQLException
    {
        cityRepository.save(city);
    }
    public void updateCity(City city) throws SQLException
    {
        cityRepository.save(city);
    }
    public List<City> findAll()
    {
        return cityRepository.findAll();
    }
    public Optional<City> findbyId(long Id)
    {
        return cityRepository.findAllById(Id);
    }
}
