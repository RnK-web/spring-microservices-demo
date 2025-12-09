package com.rdgs.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    @Value("${app.url.product}")
    private String productUrl;

    @Value("${app.url.order}")
    private String orderUrl;

    @Value("${app.url.inventory}")
    private String inventoryUrl;

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r.path("/api/v1/orders/**").uri(orderUrl))
                .route("product-service", r -> r.path("/api/v1/products/**").uri(productUrl))
                .route("inventory-service", r -> r.path("/api/v1/inventory/**").uri(inventoryUrl))
                .build();
    }

}
