package com.example.Task.service.Impl;

import com.example.Task.repository.AddressRepo;
import com.example.Task.entity.Address;
import com.example.Task.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile(value = {"Local","Dev","Prod"})
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepo addressRepo;

    @Override
    public Address createAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    @Override
    public Address getAddressById(Long add_id) {
        return addressRepo.findById(add_id).orElse(null);
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public void deleteAddress(Long add_id) {
        addressRepo.deleteById(add_id);
    }
}
