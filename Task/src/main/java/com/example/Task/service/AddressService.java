package com.example.Task.service;

import com.example.Task.entity.Address;

import java.util.List;

public interface AddressService {
    Address createAddress(Address address);
    List<Address> getAllAddresses();
    Address getAddressById(Long add_id);
    Address updateAddress(Address address);
    void deleteAddress(Long add_id);
}

