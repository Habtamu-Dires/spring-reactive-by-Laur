package com.example.services;

import com.example.model.Product;
import com.example.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Flux<Product> getProducts(){
        return repository.findAll()
                .delayElements(Duration.ofSeconds(5)); // for any element add a sleep duration
    }
}
