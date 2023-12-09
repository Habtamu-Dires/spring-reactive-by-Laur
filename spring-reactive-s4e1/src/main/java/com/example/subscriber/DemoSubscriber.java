package com.example.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;

@Component
public class DemoSubscriber implements Subscriber<Integer> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);   // Backpressure
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("onNext " + integer);
        subscription.request(1);
        if(integer == 3) subscription.cancel();
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete ");
    }
}
