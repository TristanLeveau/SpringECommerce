package com.example.demo.products;

import com.example.demo.productTypes.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "Product")
public class Product {

    public Product(Integer productId, ProductType productType, String productName, double productPrice, String productColor, String productSize, String productDescription, String otherDetails) {
        this.productId = productId;
        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productSize = productSize;
        this.productDescription = productDescription;
        this.otherDetails = otherDetails;
    }

    public Product() {

    }

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private ProductType productType;


    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "product_color")
    private String productColor;
    @Column(name = "product_size")
    private String productSize;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "other_details")
    private String otherDetails;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }
}
