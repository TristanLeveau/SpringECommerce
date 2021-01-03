package com.example.demo.customers;

import com.example.demo.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@SessionAttributes({"connectedUser", "selectedProducts"})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/home")
    public ModelAndView home(HttpServletRequest servletRequest) {
        HttpSession session = servletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        if (session.getAttribute("connectedUser") == null) {
            modelAndView.setViewName("redirect:/welcome");
            session.invalidate();
        } else {
            modelAndView.setViewName("home");
        }

        return modelAndView;

    }

    @GetMapping(path = "/cart")
    public ModelAndView cart(HttpServletRequest servletRequest) {
        HttpSession session = servletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        if (session.getAttribute("connectedUser") == null) {
            modelAndView.setViewName("redirect:/welcome");
            session.invalidate();
        } else {
            modelAndView.setViewName("cart");
        }

        return modelAndView;

    }

    @GetMapping(path = "/profile")
    public ModelAndView profile(HttpServletRequest servletRequest) {
        HttpSession session = servletRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();
        if (session.getAttribute("connectedUser") == null) {
            modelAndView.setViewName("redirect:/welcome");
            session.invalidate();
        } else {
            modelAndView.setViewName("profile");
        }

        return modelAndView;

    }

    @GetMapping(path = "/customers/all")
    public List<Customer> getAllCustThruRepo() {
        return customerService.getAllCustomer();
    }

    @GetMapping(path = "/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }


    @GetMapping(path = "/sign-in")
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView("sign-in");
        modelAndView.addObject("arrivingCustomer", new Customer());
        return modelAndView;
    }

    @PostMapping(path = "/sign-in")
    public ModelAndView getCustomerByEmailAndPassword(Customer customer) {

        ModelAndView modelAndView = new ModelAndView();
        Optional<Customer> attemptedCustomer = customerService.getCustomerByEmail(customer.getEmail(), customer.getPassword());
        if (!attemptedCustomer.isPresent()) {
            modelAndView.setViewName("sign-in-error");
        } else {
            List<Product> products = new ArrayList<Product>();
            modelAndView.addObject("customer", attemptedCustomer);
            modelAndView.addObject("connectedUser", attemptedCustomer.get());
            modelAndView.addObject("selectedProducts", products);
            modelAndView.setViewName("home");
        }
        return modelAndView;
    }

    @GetMapping(path = "/sign-up")
    public ModelAndView addCustomer() {
        ModelAndView modelAndView = new ModelAndView("sign-up");
        modelAndView.addObject("newCustomer", new Customer());
        return modelAndView;
    }

    @PostMapping(path = "/sign-up", consumes = {"application/x-www-form-urlencoded"})
    public ModelAndView addNewCustomer(Customer customer) {
        customerService.addCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("sign-up-success");
        return modelAndView;
    }

    @PutMapping(path = "/customers/update/{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }


    @DeleteMapping(path = "/customers/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }

}
