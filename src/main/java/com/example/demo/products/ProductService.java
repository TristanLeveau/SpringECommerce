package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<Product>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

  /*  public List<Product> getProductsByTypeId(Integer typeId){
        List<Product> products = new ArrayList<Product>();
        productRepository.findProductByTypeId(typeId).forEach(products::add);
        return products;
    } */

    public Optional<Product> getProductById(Integer productId) {
        return productRepository.findById(productId);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }

    public List<Product> getProductsByTypeId(Integer id) {
        return productRepository.findByProductType_ProductTypeId(id);
    }
}
