package com.example.springbootrestjpa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    
    private @Value("${product.name}") String name; 
    private @Value("${product.version}") String version; 

    public String getProductName() {        
        return this.name; 
    }

    public String getProductVersioin() {        
        return this.version; 
    }
}
