package com.skillsoft.springboot.service;

import com.skillsoft.springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = Arrays.asList(
            new Product("P101", "Monitor", "Electronics"),
            new Product("P102", "Blanket", "Household"),
            new Product("P103", "Laptop", "Electronics"),
            new Product("P104", "Shirt", "Fashion"),
            new Product("P105", "Pens", "School")
    );

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }
}
