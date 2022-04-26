package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public interface IOrderCalculator {
	
	public double calculateTotalOrderAmount(Order order);
	public double calcuateTotalOrderItemPrice(OrderItem orderItem);
	public double getSizeRateAmount(OrderItemSize orderItemSize);
	public double calculateTotalOrderAmountVAT(double totalOrderAmount);
	/**
	 * returns VAT rate as decimal when parameter = true otherwise returns VAT rate as percentage 
	 * @param return as decimal yes / no
	 * @return rate as decimal or as percentage value
	 */
	public double getVATRate(boolean decimal);
}
