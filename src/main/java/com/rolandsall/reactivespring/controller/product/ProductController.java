package com.rolandsall.reactivespring.controller.product;

import com.rolandsall.reactivespring.models.Product;
import com.rolandsall.reactivespring.services.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        Flux<Product> productServiceList = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productServiceList);
    }

    @PostMapping
    public ResponseEntity  addProduct(@RequestBody PostProductApiRequest productApiRequest){
        Mono<Product> productMono = productService.addProduct(buildFrom(productApiRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(productMono);
    }

    private Product buildFrom(PostProductApiRequest productApiRequest) {
        return new Product().builder()
                .description(productApiRequest.getDescription())
                .name(productApiRequest.getName())
                .build();
    }
}
