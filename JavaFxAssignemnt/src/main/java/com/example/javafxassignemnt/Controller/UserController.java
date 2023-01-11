package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.Country;
import com.example.javafxassignemnt.entity.User;
import com.example.javafxassignemnt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public void insertRecord(User user)throws SQLException
    {
       userRepository.save(user);
    }

    public void updatePayment(User user)
    {
        userRepository.save(user);
    }
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    public Optional<User> findById(long id)
    {
        return userRepository.findById(id);
    }

    public User findClassIDbyClass(String val)
    {
        List<User> user=userRepository.findAll();
        for(User obj:user)
        {
            if(Objects.equals(obj.getName(), val))
            {
                return obj;
            }
        }
        return null;
    }
}
