package com.example.demo.orderItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItems(){
        List<OrderItem> orderItems = new ArrayList<>();
        orderItemRepository.findAll().forEach(orderItems::add);
        return orderItems;
    }

    public Optional<OrderItem> getOrderItemById(Integer orderItemId){
        return orderItemRepository.findById(orderItemId);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItemRepository.save(orderItem);
    }

    public void updateOrderItem(OrderItem orderItem){
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Integer orderItemId){
        orderItemRepository.deleteById(orderItemId);
    }
}
