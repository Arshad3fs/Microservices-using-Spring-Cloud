package com.village.villageeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VillageEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VillageEurekaServerApplication.class, args);
	}

}
