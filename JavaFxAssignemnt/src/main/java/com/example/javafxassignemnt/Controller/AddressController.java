package com.example.javafxassignemnt.Controller;

import com.example.javafxassignemnt.entity.Address;
import com.example.javafxassignemnt.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    public void insertAddress(Address address) throws SQLException
    {
        addressRepository.save(address);
    }
    public void updatePayment(Address address) throws SQLException
    {
        addressRepository.save(address);
    }
    public List<Address> findAll()
    {
        return addressRepository.findAll();
    }
    public Optional<Address> findbyId(long Id)
    {
        return addressRepository.findAllById(Id);
    }
}
