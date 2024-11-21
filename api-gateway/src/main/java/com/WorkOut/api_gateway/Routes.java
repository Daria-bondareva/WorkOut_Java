package com.WorkOut.api_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration(proxyBeanMethods = false)
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> workOutServiceRoute(){
        return route("catalogservice")
                .route(RequestPredicates.path("/api/catalog"), http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> reviewServiceRoute() {
        return route("reviewservice")
                .route(RequestPredicates.path("/api/review"), http("http://localhost:8081"))
                .build();
    }
}
