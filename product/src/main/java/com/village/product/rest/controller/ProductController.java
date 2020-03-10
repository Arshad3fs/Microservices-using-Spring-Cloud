package com.village.product.rest.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.village.product.domain.Product;
import com.village.product.service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getProducts")
	public List<Product> getProducts(@RequestParam(required = false) String name, 
			@RequestParam(required = false) String type, 
			@RequestParam(required = false) Long price){
		
		if(name == null && type == null && price == null)
			return new ArrayList<Product>();
		
		return productService.getProducts(name, type, price);
	}
}
