package com.example.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.msscbrewery.services.CustomerService;
import com.example.msscbrewery.web.model.BeerDto;
import com.example.msscbrewery.web.model.CustomerDto;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerID") UUID customerID){
        return new ResponseEntity<>(customerService.getCustomerById(customerID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedDto = customerService.createCustomer(customerDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        //TODO: add host name to URL
        httpHeaders.add("Location","/api/v1/beer/"+savedDto.getId().toString());
        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/{customerID}")
    public ResponseEntity updateCustomer(@PathVariable("customerID") UUID customerID,@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerID,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @ResponseBody(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerID") UUID customerID){
        customerService.deleteById(customerID);
    }

}
