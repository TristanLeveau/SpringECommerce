package com.example.demo;

import com.example.demo.customers.Customer;
import com.example.demo.customers.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OtherTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = (ArrayList<Customer>) customerRepository.findAll();
        System.out.println(customers);

    }

//    Customers customer3 = new Customers(3, "Testtestest", "Jacques", "jean.jacques@gmail.com","0623456789","34 Rue Belle", "Montargis", "92000", "Pays2");


}
