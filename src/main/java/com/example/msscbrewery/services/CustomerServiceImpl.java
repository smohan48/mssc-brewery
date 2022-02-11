package com.example.msscbrewery.services;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.msscbrewery.web.model.BeerDto;
import com.example.msscbrewery.web.model.CustomerDto;

@Slf4j
@Service
public class CustomerServiceImpl
        implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerID) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("John Adams")
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDto updateCustomer(UUID customerID, CustomerDto customerDto) {
        return null;
    }

    @Override
    public void deleteById(UUID customerID) {
log.debug("deleted customer");
    }
}
