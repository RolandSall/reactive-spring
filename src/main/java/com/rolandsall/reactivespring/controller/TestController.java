package com.rolandsall.reactivespring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController

public class TestController {


    @GetMapping("/flux")
    public Flux<Integer> fluxInteger(){
        return Flux.just(1,2,3,4,5)
                .log();
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> fluxFluxStreamInteger(){
        return Flux.just(1,2,3,4,5)
                .delayElements(Duration.ofSeconds(1))
                .log();
    }
}
