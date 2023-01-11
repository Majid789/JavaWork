package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.Country;
import com.example.javafxassignemnt.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    public void insertCountry(Country country) throws SQLException
    {
        countryRepository.save(country);
    }
    public void updateCountry(Country country) throws SQLException
    {
        countryRepository.save(country);
    }
    public List<Country> findAll()
    {
        return countryRepository.findAll();
    }
    public Optional<Country> findbyId(long Id)
    {
        return countryRepository.findAllById(Id);
    }

    public Integer findClassIDbyClass(String val)
    {
        List<Country> country=countryRepository.findAll();
        for(Country obj:country)
        {
            if(Objects.equals(obj.getName(), val))
            {
                return obj.getId();
            }
        }
        return null;
    }
}
