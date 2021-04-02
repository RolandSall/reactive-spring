package com.rolandsall.reactivespring.reactive_tests;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class MonoTest {

    @Test
    public void monoTest() {
        Mono<String> stringMono = Mono.just("Spring");

        StepVerifier.create(stringMono.log())
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    public void monoTest_Error() {
        Mono<String> stringMono = Mono.just("Spring");

        StepVerifier.create(Mono.error(new RuntimeException("Exception Happened")).log())
                .expectError(RuntimeException.class)
                .verify();
    }
}
