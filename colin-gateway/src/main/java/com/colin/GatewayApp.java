package com.colin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author colin
 * @create 2022-06-26 17:20
 */
@SpringBootApplication
public class GatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class,args);
    }

    // API 方式
    @Bean
    public RouteLocator someRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route(ps -> ps.header("X-Request-color","\\d+")
                        .filters(fs -> fs.addRequestParameter("color","green"))
                        .uri("http://localhost:8000/info/param")
                        .id("color_route"))
                .build();
    }

}
