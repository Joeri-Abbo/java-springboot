package com.skillsoft.springboot.exception;

import java.io.Serial;

public class ProductNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(Long id) {
        super("The product with " + id + " cannot be found!");
    }
}
