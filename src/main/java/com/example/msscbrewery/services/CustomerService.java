package com.example.msscbrewery.services;

import java.util.UUID;

import com.example.msscbrewery.web.model.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerID);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(UUID customerID, CustomerDto customerDto);

    void deleteById(UUID customerID);
}
