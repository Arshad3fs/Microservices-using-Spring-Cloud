package com.village.order.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.order.domain.Order;
import com.village.order.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getOrderDetails/{orderID}")
	public Order getOrderDetails(@PathVariable("orderID") Long orderID) {
		
		return orderID != null ? orderService.getOrderDetails(orderID) : null;
	}
}
