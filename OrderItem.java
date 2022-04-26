package org.makerminds.jcoaching.restaurantapp.model.order;

import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class OrderItem {
	
	private Product product;
	private OrderItemSize orderItemSize;
	private int quantity;
	private double orderItemPrice;
	
	public OrderItem(Product product, OrderItemSize orderItemSize, int quantity) {
		this.product = product;
		this.orderItemSize = orderItemSize;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderItemSize getOrderItemSize() {
		return orderItemSize;
	}

	public void setOrderItemSize(OrderItemSize orderItemSize) {
		this.orderItemSize = orderItemSize;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getOrderItemPrice() {
		return orderItemPrice;
	}

	public void setOrderItemPrice(double orderItemPrice) {
		this.orderItemPrice = orderItemPrice;
	}
}