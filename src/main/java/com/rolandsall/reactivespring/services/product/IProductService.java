package com.rolandsall.reactivespring.services.product;

import com.rolandsall.reactivespring.models.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {


    Flux<Product> findAll();

    Mono<Product> addProduct(Product product);
}
