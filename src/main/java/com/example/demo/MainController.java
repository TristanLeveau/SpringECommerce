package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController implements ErrorController {

    @RequestMapping(path = "/welcome")
    public ModelAndView welcome() {

        ModelAndView modelAndView = new ModelAndView("index");
        String homeTitle = "Spring E-Commerce";
        String homeSubTitle = "This is an e-commerce template.";
        modelAndView.addObject("Title", homeTitle);
        modelAndView.addObject("Subtitle", homeTitle);
        return modelAndView;
    }

    @RequestMapping(path = "/error")
    public ModelAndView error() {
        return new ModelAndView("error");
    }


    @RequestMapping(path = "/generic")
    public static String generic() {
        return "generic";
    }

    @RequestMapping(path = "/customers")
    public static String customers() {
        return "customers";
    }

    @RequestMapping(path = "/orders")
    public static String orders(){
        return "orders";
    }

    @RequestMapping(path = "/products")
    public static String products() {
        return "products";
    }

    @RequestMapping(path = "/product-types")
    public static String productTypes() {
        return "product-types";
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
