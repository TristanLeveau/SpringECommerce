package com.example.demo.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/all")
    public List<Customer> getAllCustThruRepo(){
        return customerService.getAllCustomer();
    }

    @GetMapping(path = "/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Integer id){
        return customerService.getCustomerById(id);
    }

    @PostMapping(path = "/add")
    public void addNewCustomer(@RequestBody Customer customer){ customerService.addCustomer(customer); }

    @PutMapping(path = "/update/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
    }

}
