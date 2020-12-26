package com.example.demo.orderItems;

import com.example.demo.orders.Order;
import com.example.demo.products.Product;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Entity(name = "OrderItem")
@Table(name = "Order_Item")
public class OrderItem {

    public OrderItem() {
    }

    public OrderItem(Integer orderItemId, Order order, Product product, Integer itemQuantity, double itemPrice, String otherDetails) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.product = product;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.otherDetails = otherDetails;
    }

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "order_item_quantity")
    private Integer itemQuantity;
    @Column(name = "order_item_price")
    private double itemPrice;
    @Column(name = "order_item_other_details")
    private String otherDetails;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
