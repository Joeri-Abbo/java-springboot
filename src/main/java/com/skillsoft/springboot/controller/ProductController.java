package com.skillsoft.springboot.controller;

import com.skillsoft.springboot.model.Product;
import com.skillsoft.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllTopics() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{pid}")
    public Product getProduct(@PathVariable("pid") String id) {
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getCategory());
        productService.addProduct(product);
    }
}
