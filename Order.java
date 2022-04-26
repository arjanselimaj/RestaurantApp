package org.makerminds.jcoaching.restaurantapp.model.order;

import java.util.ArrayList;

public class Order {
	
	private double totalOrderAmount;
	private double totalOrderAmountVAT;
	private double totalOrderAmountWithVAT;
	private double vatRate;
	
	private ArrayList<OrderItem> orderItems = new ArrayList<>();
	
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public double getTotalOrderAmountVAT() {
		return totalOrderAmountVAT;
	}

	public void setTotalOrderAmountVAT(double totalOrderAmountVAT) {
		this.totalOrderAmountVAT = totalOrderAmountVAT;
	}

	public double getTotalOrderAmountWithVAT() {
		return totalOrderAmountWithVAT;
	}

	public void setTotalOrderAmountWithVAT(double totalOrderAmountWithVAT) {
		this.totalOrderAmountWithVAT = totalOrderAmountWithVAT;
	}

	public double getVatRate() {
		return vatRate;
	}

	public void setVatRate(double vatRate) {
		this.vatRate = vatRate;
	}
}