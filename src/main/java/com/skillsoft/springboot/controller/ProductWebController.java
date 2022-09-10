package com.skillsoft.springboot.controller;

import com.skillsoft.springboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductWebController {
    @Autowired
    ProductController productController;

    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<Product> productList = productController.getAllProducts();

        model.addAttribute("products", productList);

        return "list_products";
    }

    @GetMapping("/new_product")
    public String addProduct(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);

        return "new_product";
    }

    @PostMapping("/save_new")
    public String saveNewProduct(@ModelAttribute("product") Product product) {
        productController.addProduct(product);

        return "redirect:/";
    }
}
