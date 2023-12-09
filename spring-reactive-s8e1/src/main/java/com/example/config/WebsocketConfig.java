package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Sinks;

import java.util.Map;

@Configuration
public class WebsocketConfig {

    @Bean   // mapping urls with a specific session
    public SimpleUrlHandlerMapping handlerMapping(WebSocketHandler wsh){
        return new SimpleUrlHandlerMapping(Map.of("/ws/messages", wsh), 1);
    }

    @Bean   // add websocketHandlerAdapter into a context
    public WebSocketHandlerAdapter webSocketHandlerAdapter(){
        return new WebSocketHandlerAdapter();
    }

    @Bean
    public Sinks.Many<String> sink() {
        return Sinks.many().multicast().directBestEffort();
    }
}
