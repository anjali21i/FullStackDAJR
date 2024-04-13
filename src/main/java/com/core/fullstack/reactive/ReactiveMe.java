package com.core.fullstack.reactive;

import java.util.ArrayList;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveMe {
    public static void main(String[] args) {
    	
    	List<Integer> list = new ArrayList<>();
    	list.add(2);
    	list.add(3);
    	list.add(54);
    	
        //data stream
        Flux<Integer> numberLis = Flux.just(list.get(0), list.get(2));

        //data stream
        Flux<Integer> numbers = Flux.just(1,2,3,4,5);
        
        // Subscribing Flux to consume the emitted values
        numbers.subscribe(
            value -> System.out.println("Received: " + value),  // onNext callback
            error -> System.err.println("Error: " + error),     // onError callback
            () -> System.out.println("Completed")               // onComplete callback
        );

        //publisher of at most one value emitting
        Mono<String> mono = Mono.just("Hello, Reactive World!");

        // Subscribing Mono to consume the emitted value
        mono.subscribe(
            value -> System.out.println("Received: " + value),  // onNext callback
            error -> System.err.println("Error: " + error),     // onError callback
            () -> System.out.println("Completed")               // onComplete callback
        );
    }
}
