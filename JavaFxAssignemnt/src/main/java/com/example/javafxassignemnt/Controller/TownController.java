package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.Town;
import com.example.javafxassignemnt.entity.User;
import com.example.javafxassignemnt.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class TownController {

    @Autowired
    private TownRepository townRepository;

    public void insertTown(Town town) throws SQLException
    {
        townRepository.save(town);
    }
    public void updateTown(Town town) throws SQLException
    {
        townRepository.save(town);
    }
    public List<Town> findAll()
    {
        return townRepository.findAll();
    }
    public Optional<Town> findbyId(long Id)
    {
        return townRepository.findAllById(Id);
    }

    public Town findClassIDbyClass(String val)
    {
        List<Town> towns=townRepository.findAll();
        for(Town obj:towns)
        {
            if(Objects.equals(obj.getName(), val))
            {
                return obj;
            }
        }
        return null;
    }
}
