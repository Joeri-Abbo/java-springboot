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
        productService.addProduct(product);
    }

    @PutMapping("/products/{pid}")
    public void updateProduct(@RequestBody Product product, @PathVariable("pid") String id) {
        productService.updateProduct(id, product);
    }
}
