package com.example.demo.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;

    }

    public Optional<Order> getOrderById(Integer orderId){
        return orderRepository.findById(orderId);
    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }

    public void updateOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(Integer orderId){
        orderRepository.deleteById(orderId);
    }
}
