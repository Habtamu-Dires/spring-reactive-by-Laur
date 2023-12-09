package com.example.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class DemoController {

    @GetMapping(value = "/demo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    // never try to return that is not a publisher
    public Flux<String> demo(){
        Flux<String> f1 = Flux.just("AAA","AAA","BB", "C","DDDDD", "AAA");
        Flux<String> f2 = Flux.just("qwert", "qaz", "sss");

        //spring boot attaches a subscriber.
        return f1
//                .delayElements(Duration.ofSeconds(2))
//                .filter(s -> s.length() % 2 == 0)
//                .log();
//                .distinct();
//                .distinctUntilChanged();
//                .map(s ->s.length());
//                .flatMap(s -> Flux.just(s.split(""))); // Flux<Flux<String>>
//                .doOnNext(s -> System.out.println(s));
//                .collect(Collectors.toList());
//                .collect(Collectors.summingInt(s -> s.length()));
//                .concatWith(f2);
//                .doOnNext(System.out::println)
//                .thenMany(f2);
                .zipWith(f2, (x,y) -> x + "=" + y)
                .log();
    }
}
