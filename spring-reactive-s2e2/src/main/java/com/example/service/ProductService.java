package com.example.service;

import com.example.model.Product;
import com.example.proxy.ProductProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    private final ProductProxy proxy;

    public ProductService(ProductProxy proxy) {
        this.proxy = proxy;
    }

    public Flux<Product> getAll(){
        return proxy.getAll();
    }
}

