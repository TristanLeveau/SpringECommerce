package com.example.demo.productTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product-types")
public class ProductTypeController {

    @Autowired
 private ProductTypeService productTypeService;

 @GetMapping(path = "/all")
    public List<ProductType> getAllProductTypes(){ return productTypeService.getAllProductTypes(); }

    @PostMapping(path = "/add")
    public void addProductType(ProductType productType){productTypeService.addProductType(productType);}

    @GetMapping("/{id}")
    public Optional<ProductType> getProductTypeById(@PathVariable Integer id){
        return productTypeService.getProductTypeById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteProductType(@PathVariable Integer id){
        productTypeService.deleteProductType(id);
    }

    @PutMapping(path = "/update")
    public void updateProductType(ProductType productType){
        productTypeService.updateProductType(productType);
    }
}
