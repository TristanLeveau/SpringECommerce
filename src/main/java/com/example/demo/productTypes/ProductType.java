package com.example.demo.productTypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ProductType")
@Table(name = "Product_Type")
public class ProductType {

    public ProductType() {

    }

    public ProductType(Integer productTypeId, ProductType parentType, String productTypeDescription) {
        this.productTypeId = productTypeId;
        this.parentType = parentType;
        this.productTypeDescription = productTypeDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_type_id")
    private Integer productTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "parent_product_type_id")
    private ProductType parentType;

    @OneToMany(mappedBy = "parentType")
    @JsonIgnore
    private Set<ProductType> childTypes = new HashSet<>();

    @Column(name = "product_type_description")
    private String productTypeDescription;

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public ProductType getParentType() {
        return parentType;
    }

    public void setParentType(ProductType parentType) { this.parentType = parentType; }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    public Set<ProductType> getChildTypes() {
        return childTypes;
    }

    public void setChildTypes(Set<ProductType> childTypes) {
        this.childTypes = childTypes;
    }
}
