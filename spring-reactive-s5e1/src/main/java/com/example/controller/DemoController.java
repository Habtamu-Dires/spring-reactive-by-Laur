package com.example.controller;

import com.example.publisher.DemoPublisher;
import com.example.subscriber.DemoSubscriber;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo(){
        // Stream vs Reactor
//        Flux<Integer> f1 = Flux.just(1,2,3,4,5,6);  // publisher
//
//        f1.subscribe(c -> System.out.println(c));    // subscriber

//        Stream<Integer> s1 = Stream.of(1,2,3,4,5,6);
//        s1.forEach(System.out::println);    //-> subscriber pulls value from the publisher

//        Flux<Integer> f1 = Flux.just(1,2,3,3,5,6);  // the publisher pushes events

//        DemoPublisher f1 = new DemoPublisher(List.of(1,2,3,4,5,6));
//
//        f1.subscribe(new DemoSubscriber());

        Flux<String> f1 = Flux.create(s -> {     //sink - flush events into stream
           for(int i=0; i<10; i++){
               s.next(UUID.randomUUID().toString()); // produce next event
           }
           s.complete(); // signal the complete
            // s.error();  -> signal the error
        });

//        f1.log()
//            .subscribe(c -> System.out.println(c));  // request(indefinite) i.e does n't use back pressure
//        f1.log()
//                .subscribe(new Subscriber<String>() {
//
//                    private Subscription subscription;
//                    private int i =0;
//
//                    @Override
//                    public void onSubscribe(Subscription subscription) {
//                        this.subscription = subscription;
//                        subscription.request(2);
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println("on-next-> " + s);
//                        i++;
//                        if(i % 2 == 0) {
//                            this.subscription.request(2);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("on-complete");
//                    }
//                });

//        Flux<Integer> f2 = Flux.just(1,2,3,4,5);
//
//        f2.subscribe(c->System.out.println(c));
//        System.out.println("second");
//        f2.subscribe(c->System.out.println(c));
//        f2.subscribe(c->System.out.println(c));

//        Stream<Integer> s = Stream.of(1,2,4,5,6);
//        //s.forEach(System.out::println);
//        //s.forEach(System.out::println);
//        Stream<Integer> integerStream = s.filter(x -> x < 3);
//
//        s.forEach(System.out::println);

    }
}
