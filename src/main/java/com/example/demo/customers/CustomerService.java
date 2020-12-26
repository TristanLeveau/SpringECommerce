package com.example.demo.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){

        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);

        return customers;

    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, Customer customer){
        customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Integer customerId){
        return customerRepository.findById(customerId);
    }

    public void deleteCustomer(Integer customerId){
        customerRepository.deleteById(customerId);
    }

  /*  List<Customers> customers = new ArrayList<>(Arrays.asList(customer1,customer2));

    public List<Customers> getAllCustomers(){
        return customers;
    }

    public Customers getCustomerById(Integer id){

        return customers.stream()
                .filter(t  -> id.equals(t.getCustomerId()))
                .findFirst()
                .orElse(null);
    }

    public void addNewCustomer(Customers customer){
        customers.add(customer);
    }


    public void updateCustomer(Integer customerId, Customers customer) {
        for (int i =0; i<customers.size();i++){
            Customers c = customers.get(i);
            if(c.getCustomerId().equals(customerId)){
                customers.set(i, customer);
            }
        }
    }

    public void deleteCustomer(Integer id) {
        for (int i =0; i<customers.size();i++){
            Customers c = customers.get(i);
            if(c.getCustomerId().equals(id)){
                customers.remove(i);
            }
        }

    }*/
}
