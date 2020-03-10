package com.village.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class VillageGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(VillageGatewayApplication.class, args);
	}
	
	@GetMapping("/")
	public String message() {
		return "Server is up & running";
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
				.route(r -> r.path("/getAnyAddress")
						.uri("http://localhost:8000"))
				.build();
		//@formatter:on
	}
	
}
