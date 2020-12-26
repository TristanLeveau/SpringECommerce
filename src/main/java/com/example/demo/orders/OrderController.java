package com.example.demo.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public void addOrder(Order order){
        orderService.addOrder(order);
    }

    @PutMapping("/update")
    public void updateOrder(Order order){
        orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }
}
