package com.example.demo.products;

import com.example.demo.productTypes.ProductType;
import com.example.demo.productTypes.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@SessionAttributes("connectedUser")
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/products")
    public ModelAndView getAllProducts(HttpServletRequest httpRequest) {

        HttpSession session = httpRequest.getSession();
        ModelAndView modelAndView = new ModelAndView();

//        if (session.getAttribute("connectedUser") == null) {
//            modelAndView.setViewName("sign-in");
//        } else {
        List<Product> products = productService.getAllProducts();
        modelAndView.addObject("products", products);
        modelAndView.setViewName("products");
//        }


        return
                modelAndView;
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }


    @GetMapping("/products/details/{id}")
    public ModelAndView getProductDetails(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("product-details");
        modelAndView.addObject("product", productService.getProductById(id).get());
        return modelAndView;
    }


    @GetMapping("/type/{id}")
    public List<Product> getProductsByTypeId(@PathVariable Integer id) {
        return productService.getProductsByTypeId(id);
    }

    @GetMapping("/add-product")
    public ModelAndView addProductForm() {
        ModelAndView modelAndView = new ModelAndView("add-product");
        List<ProductType> productTypes = productTypeService.getAllProductTypes();
        modelAndView.addObject("productTypes", productTypes);
        modelAndView.addObject("newProduct", new Product());
        return modelAndView;
    }

    @PostMapping("/add-product")
    public ModelAndView addProduct(Product product) {

        ModelAndView modelAndView = new ModelAndView("add-success");

        productService.addProduct(product);

        return modelAndView;

    }

    @PutMapping("/update")
    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
