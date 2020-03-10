package com.village.product.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.village.product.domain.Product;

@Service
public class ProductService {
	
	private static List<Product> products; 
	
	static {
		loadProducts();
	}
	
	public List<Product> getProducts(String name, String type, Long price) {
		return products.stream().filter( product -> product.getName().equalsIgnoreCase(name) 
				|| product.getType().equalsIgnoreCase(type) 
				|| product.getPrice() == price).collect(Collectors.toList()); 
	}

	private static void loadProducts() {
		products = Arrays.asList(
				new Product("Samsung Refrigirator", "Double Door", "Auto convertible", 25000L),
				new Product("LG Refrigirator", "Double Door", "Auto convertible", 24000L),
				new Product("IPhone X", "Full Screen", "World's best mobile", 50000L),
				new Product("Mac Book", "Laptop", "World's fastest laptop", 100000L),
				new Product("LP Suite", "Wedding Suite", "Best looking suits", 15000L),
				new Product("Black Berry", "Wedding Suite", "Best suits", 16000L)
				);
	}

}
