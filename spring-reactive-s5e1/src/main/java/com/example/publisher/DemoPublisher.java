package com.example.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DemoPublisher implements Publisher<Integer> {

    private final List<Integer> list;

    public DemoPublisher(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void subscribe(Subscriber<? super Integer> subscriber) {
        // anonymous class
        Subscription subscription = new Subscription() {

            private int lastRequestedElement = -1;

            @Override
            public void request(long l) {

                int index = 1;
                while (l > index){    //backpressure
                    lastRequestedElement++;
                    if(lastRequestedElement < list.size()){
                        subscriber.onNext(list.get(lastRequestedElement));
                    } else{
                        subscriber.onComplete();
                        break;
                    }
                    index++;
                }
            }

            @Override
            public void cancel() {

            }
        };
        subscriber.onSubscribe(subscription);
    }
}
