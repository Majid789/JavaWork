package com.airline.controller;

import com.airline.entity.Payment;
import com.airline.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;


    public void insertPayment(Payment payment) throws SQLException {
        //JdbcDao jdbcDao = new JdbcDao();
        paymentRepository.save(payment);
    }
    public void updatePayment(Payment payment){
        paymentRepository.save(payment);
    }
    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }
    public Optional<Payment> findById(int id){
        return paymentRepository.findById(id);
    }
}
