package com.rolandsall.reactivespring.repos.product;

import com.rolandsall.reactivespring.models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


public interface IProductRepositoryDTO extends ReactiveMongoRepository<Product, UUID> {
}
