package com.xsz.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeteWayConfig {


//    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes=routeLocatorBuilder.routes();

        routes.route("baidu_com",r->r.path("/guonei").
                uri("http://news.baidu.com/guonei")).build();

        routes.route("payment_route",r->r.path("/payment/get/**").
                uri("http://localhost:8010")).build();
        return routes.build();
    }
}
