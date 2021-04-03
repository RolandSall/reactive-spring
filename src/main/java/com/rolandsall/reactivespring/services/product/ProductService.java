package com.rolandsall.reactivespring.services.product;

import com.rolandsall.reactivespring.models.Product;
import com.rolandsall.reactivespring.repos.product.IProductRepositoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductService implements IProductService{

    IProductRepositoryDTO iProductRepositoryDTO;

    @Autowired
    public ProductService(IProductRepositoryDTO iProductRepositoryDTO) {
        this.iProductRepositoryDTO = iProductRepositoryDTO;
    }

    @Override
    public Flux<Product> findAll() {
        return iProductRepositoryDTO.findAll();
    }

    @Override
    public Mono<Product> addProduct(Product product) {
        UUID id = UUID.randomUUID();
        product.setId(id);
        return iProductRepositoryDTO.insert(product);
    }
}
