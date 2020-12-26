package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping(path="/home")
    public static String welcome(){
        return "index";
    }

    @RequestMapping(path="/elements")
    public static String elements(){
        return "elements";
    }

    @RequestMapping(path="/generic")
    public static String generic(){
        return "generic";
    }

    @RequestMapping(path = "/customers")
    public static String customers(){
        return "customers";
    }

    @RequestMapping(path = "/orders")
    public static String orders(){
        return "orders";
    }

    @RequestMapping(path = "/products")
    public static String products(){
        return "products";
    }

    @RequestMapping(path = "/product-types")
    public static String productTypes(){
        return "product-types";
    }


}
