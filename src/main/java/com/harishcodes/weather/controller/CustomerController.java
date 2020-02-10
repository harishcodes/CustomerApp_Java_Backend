package com.harishcodes.weather.controller;

import com.harishcodes.weather.entity.Customer;
import com.harishcodes.weather.model.CustomerOutput;
import com.harishcodes.weather.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class CustomerController {


    @Autowired
    CustomerService customerService;


    @PostMapping("/saveCustomer")
    public ResponseEntity<?> saveCustomerDetails(@RequestBody Customer customer ){
        System.out.println("customer :" + customer);
        CustomerOutput customerOutput = new CustomerOutput();
        try {

            customerService.saveCustomerDet(customer);
            Long idValue = customerService.getIdCustomer();
            customerOutput.setId(idValue);
            customerOutput.setMessage("Success");
            customerOutput.setErrorMessage("");
        } catch (Exception e) {
            System.out.println("Error :"+ e.getMessage());
            customerOutput.setErrorMessage("Error");
        }
        return new ResponseEntity<>(customerOutput,HttpStatus.OK);
    }

    @GetMapping("/sample")
    public String test() {
        return "Hi";
    }

}
