package com.example.demo_spring_webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("String Mono")
                .then(Mono.error(new RuntimeException("Exception Occurred")))
                .log();
        monoString.subscribe(System.out::println , (e) -> System.out.println(e.getMessage())); // whenever a subscriber will invoke subscribe method of Publisher , immediately publisher starts emitting the events
    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("Spring","SpringBoot","Reactor","WebFlux")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occurred")))
                .concatWithValues("Added After Error")
                .log();
        fluxString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }
}
