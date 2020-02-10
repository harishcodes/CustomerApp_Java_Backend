package com.harishcodes.weather.repository;

import com.harishcodes.weather.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    @Query("select max(id) from Customer")
    Long getLatestIdCustomer();

}
