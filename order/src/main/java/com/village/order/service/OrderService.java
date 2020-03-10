package com.village.order.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.village.order.domain.Address;
import com.village.order.domain.Order;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@Service
public class OrderService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancer;

	@Autowired
	private RestTemplate restTemplate;

	private static List<Order> orders;

	static {
		loadOrders();
	}

	public Order getOrderDetails(Long orderID) {
		Order matchedOrder = orders.parallelStream().filter(order -> orderID == order.getOrderNumber()).findFirst()
				.orElse(null);
		if (matchedOrder == null)
			return null;

		ServiceInstance serviceInstance = loadBalancer.choose("Address-Eureka-Client");
		
		System.out.println("*********************"+serviceInstance.getUri());

		Address address = performApiCall(serviceInstance.getUri().toString() + "/Address/getAnyAddress");

		System.out.println(address);

		matchedOrder.setDeliverAddress(address);

		return matchedOrder;
	}

	@HystrixCommand(fallbackMethod = "defaultOrder")
	private Address performApiCall(String url) {

		return restTemplate.getForObject(url, Address.class);
	}

	private Order defaultOrder() {
		return new Order(0L, "Dummy", "00/00/0000");
	}

	private static void loadOrders() {
		orders = Arrays.asList(new Order(100L, "COD", "24/02/2020"), new Order(101L, "Online", "26/02/2020"),
				new Order(102L, "COD", "27/02/2020"), new Order(103L, "COD", "28/02/2020"),
				new Order(104L, "Online", "29/02/2020"), new Order(105L, "COD", "23/02/2020"),
				new Order(106L, "Online", "22/02/2020"), new Order(107L, "Online", "21/02/2020"),
				new Order(108L, "COD", "20/02/2020"));
	}

}
