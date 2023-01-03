package com.nhnacademy.booklaygateway.config;

import java.util.UUID;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                      .route("get_route", r -> r.path("/get")
                                                .filters(o->o.addRequestHeader("uuid", UUID.randomUUID().toString()))
                                                .uri("http://httpbin.org"))
                      .build();
    }
}
