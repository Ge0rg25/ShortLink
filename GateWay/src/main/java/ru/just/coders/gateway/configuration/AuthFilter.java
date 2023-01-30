package ru.just.coders.gateway.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(-1)
public class AuthFilter implements GlobalFilter {

    final Logger logger =
            LoggerFactory.getLogger(
                    AuthFilter.class);

    @Override
    public Mono<Void> filter(
        ServerWebExchange exchange,
        GatewayFilterChain chain
    ) {
        logger.info(
                new StringBuilder()
                        .append("Got ")
                        .append(exchange.getRequest().getMethod().name())
                        .append(" request, path: ")
                        .append(exchange.getRequest().getURI().getPath())
                        .toString()
        );

        return chain.filter(exchange);
    }
}