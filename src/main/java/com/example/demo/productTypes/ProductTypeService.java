package com.example.demo.productTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> getAllProductTypes(){
        List<ProductType> productTypes = new ArrayList<>();
        productTypeRepository.findAll().forEach(productTypes::add);
        return productTypes;
    }

    public void addProductType(ProductType productType){
        productTypeRepository.save(productType);
    }

    public void updateProductType(ProductType productType){
        productTypeRepository.save(productType);
    }

    public Optional<ProductType> getProductTypeById(Integer productId){
        return productTypeRepository.findById(productId);
    }

    public void deleteProductType(Integer productId){
        productTypeRepository.deleteById(productId);
    }


}
