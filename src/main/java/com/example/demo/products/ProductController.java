package com.example.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/type/{id}")
    public List<Product> getProductsByTypeId(@PathVariable Integer id){
        return productService.getProductsByTypeId(id);
    }

    @PostMapping("/add")
    public void addProduct(Product product){
        productService.addProduct(product);
    }

    @PutMapping("/update")
    public void updateProduct(Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
