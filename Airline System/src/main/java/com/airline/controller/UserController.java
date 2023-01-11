package com.airline.controller;

import com.airline.entity.Flight;
import com.airline.entity.User;
import com.airline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;


    public void insertPayment(User user) throws SQLException {
        //JdbcDao jdbcDao = new JdbcDao();
        userRepository.save(user);
    }
    public void updatePayment(User user){
        userRepository.save(user);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }
}
