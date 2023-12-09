package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

@RestController
public class DemoController {

    private final Sinks.Many<String> sink;

    public DemoController(Sinks.Many<String> sink) {
        this.sink = sink;
    }

    @PostMapping("/demo")
    public void demo(){
        sink.emitNext("hello", Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
