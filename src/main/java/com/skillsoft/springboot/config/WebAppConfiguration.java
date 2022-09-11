package com.skillsoft.springboot.config;

import com.skillsoft.springboot.interceptor.BookHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebAppConfiguration implements WebMvcConfigurer {
    @Autowired
    private BookHandlerInterceptor bookHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bookHandlerInterceptor);
    }
}
