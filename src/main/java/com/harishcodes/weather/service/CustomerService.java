package com.harishcodes.weather.service;

import com.harishcodes.weather.entity.Customer;
import com.harishcodes.weather.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    public void saveCustomerDet(Customer customer) {
        customerRepository.save(customer);
    }

    public Long getIdCustomer() {
        return customerRepository.getLatestIdCustomer();
    }

}
