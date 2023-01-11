package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.State;
import com.example.javafxassignemnt.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    public void insertState(State state) throws SQLException
    {
        stateRepository.save(state);
    }
    public void updateState(State state) throws SQLException
    {
        stateRepository.save(state);
    }
    public List<State> findAll()
    {
        return stateRepository.findAll();
    }

    public Optional<State> findbyId(long Id)
    {

        return stateRepository.findAllById(Id);
    }


    public State findClassIDbyClass(String val)
    {
        List<State> authors=stateRepository.findAll();
        for(State obj:authors)
        {
            if(Objects.equals(obj.getName(), val))
            {
                return obj;
            }
        }
        return null;
    }
}
