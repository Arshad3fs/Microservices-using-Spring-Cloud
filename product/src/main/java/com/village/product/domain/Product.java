package com.village.product.domain;

public class Product {
	private String name;
	private String type;
	private String desc;
	private Long price;
	
	public Product(String name, String type, String desc, Long price) {
		super();
		this.name = name;
		this.type = type;
		this.desc = desc;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
}
