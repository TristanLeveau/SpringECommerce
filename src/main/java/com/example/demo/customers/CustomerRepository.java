package com.example.demo.customers;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> getCustomerByEmailAndPassword(String email, String password);

}
