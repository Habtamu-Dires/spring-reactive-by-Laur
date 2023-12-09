package com.example.handlers;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Component
public class CustomerWebsocketHandler implements WebSocketHandler {

    private final Sinks.Many<String> sinks;

    public CustomerWebsocketHandler(Sinks.Many<String> sinks) {
        this.sinks = sinks;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
//        var f = sinks.asFlux()
//                .map(s -> session.textMessage(s));
        var f = session.receive()
                .map(e -> e.getPayloadAsText())
                .map(e -> new StringBuilder(e).reverse())
                .map(e -> session.textMessage(e.toString()));

        return session.send(f);
    }
}
