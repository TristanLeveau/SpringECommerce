package com.example.demo.orders;

import com.example.demo.customers.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "Order")
@Table(name = "customer_order")
public class Order {

    public Order() {
    }

    public Order(Integer orderId, Customer customer, Integer orderStatusId, String orderDate, String orderDetails) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderStatusId = orderStatusId;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "customer_id")

    private Customer customer;
    @Column(name = "order_item_status_id")
    private Integer orderStatusId;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "order_details")
    private String orderDetails;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomerId(Customer customer) {
        this.customer = customer;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }
}
