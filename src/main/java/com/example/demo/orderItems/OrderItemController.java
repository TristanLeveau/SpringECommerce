package com.example.demo.orderItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/all")
    public List<OrderItem> getAllOrderItems(){
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable Integer id){
        return orderItemService.getOrderItemById(id);
    }

    @PostMapping("/add")
    public void addOrderItem(OrderItem orderItem){
        orderItemService.addOrderItem(orderItem);
    }

    @PutMapping("/update")
    public void updateOrderItem(OrderItem orderItem){
        orderItemService.updateOrderItem(orderItem);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderItem(@PathVariable Integer id){
        orderItemService.deleteOrderItem(id);
    }

}
