package com.village.order.domain;

public class Order {
	private Long orderNumber;
	private String paymentType;
	private String deliveryDate;
	private Address deliverAddress;
	private Product productDetails;
	
	public Order(Long orderNumber, String paymentType, String deliveryDate) {
		super();
		this.orderNumber = orderNumber;
		this.paymentType = paymentType;
		this.deliveryDate = deliveryDate;
	}
	public Long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Address getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(Address deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	public Product getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(Product productDetails) {
		this.productDetails = productDetails;
	}
}
