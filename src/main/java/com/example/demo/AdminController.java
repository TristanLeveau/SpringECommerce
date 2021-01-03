package com.example.demo;

import com.example.demo.customers.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/menu")
    public ModelAndView adminMenu(HttpServletRequest servletRequest) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = servletRequest.getSession();
        Customer customer = (Customer) session.getAttribute("connectedUser");
        if (customer.getAdmin() == true) {
            modelAndView.setViewName("admin");
        } else {
            modelAndView.setViewName("redirect:/home");
        }

        return modelAndView;

    }
}
