package com.village.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class VillageGatewayApplication {
	
	/*
	 * @Autowired private LoadBalancerClient loadBalancerClient;
	 */

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
				.route(r -> r.path("/Address/**")
						.uri("http://localhost:8000"))
						//.uri(loadBalancerClient.choose("Address-Eureka-Client").getUri().toString()))
				.route(r -> r.path("/Order/**")
						.uri("http://localhost:8002"))
						//.uri(loadBalancerClient.choose("Order-Eureka-Client").getUri().toString()))
				.route(r -> r.path("/Product/**")
						.uri("http://localhost:8001"))
						//.uri(loadBalancerClient.choose("Product-Eureka-Client").getUri().toString()))
				.build();
		//@formatter:on
	}
	
}

