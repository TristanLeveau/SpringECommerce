package com.example.demo.products;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    public List<Product> findByProductType_ProductTypeId(Integer typeId);
//    public List<Product> findProductByOrderId(Integer orderId);

}
