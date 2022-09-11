package com.skillsoft.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootApplication {
    @RequestMapping(value = "/search")
    public String search() {
        return "<h3>Searching for a product</h3>";
    }

    @RequestMapping(value = "/order")
    public String order() {
        return "<h3>Placing a product order</h3>";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
