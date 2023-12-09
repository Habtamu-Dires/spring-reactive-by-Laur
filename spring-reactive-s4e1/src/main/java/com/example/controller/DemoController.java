package com.example.controller;

import com.example.subscriber.DemoSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.concurrent.Flow;
import java.util.stream.Stream;

@RestController
public class DemoController {

    private DemoSubscriber demoSubscriber;

    public DemoController(DemoSubscriber demoSubscriber) {
        this.demoSubscriber = demoSubscriber;
    }

    @GetMapping("/demo")
    public void demo(){
        Flux<Integer> f1 =  Flux.just(1,2,3,4,5,6);
//        var f2 = Flux.fromStream(Stream.of(1,2,3,4,5,6));
//        var f3 = Flux.fromIterable(Set.of(1,2,3,4,5,6,7));
//
//        var m1 = Mono.just(1);


        f1//.doOnNext(c ->{if(c == 3) throw new RuntimeException("Nooo");})
          .subscribe(demoSubscriber);
    }
}
