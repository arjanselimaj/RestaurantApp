package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidOrderItemSizeException;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public abstract class AbstractOrderCalculator implements IOrderCalculator {
	
	/**
	 * calculates the total order amount of the given order.
	 * 
	 * @param the order the total amount should be calculated from
	 * @return total order amount
	 */
	public double calculateTotalOrderAmount(Order order) {
		ArrayList<OrderItem> orderItems = order.getOrderItems();
		double totalOrderAmount = 0.0;

		for (OrderItem orderItem : orderItems) {
			totalOrderAmount += calcuateTotalOrderItemPrice(orderItem);
		}
		return totalOrderAmount;
	}

	public double calcuateTotalOrderItemPrice(OrderItem orderItem) {
		double orderItemPriceIncludingSizeRate = calculateOrderItemPriceIncludingSizeRate(orderItem);
		return orderItemPriceIncludingSizeRate * orderItem.getQuantity();
	}

	private double calculateOrderItemPriceIncludingSizeRate(OrderItem orderItem) {
		double sizeRateAmount = 1;
		
		try {
			sizeRateAmount = getSizeRateAmount(orderItem.getOrderItemSize());
		} catch (InvalidOrderItemSizeException e) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("No valid order item size for item ").append(orderItem.getProduct().getName()).append(". Default size rate amount (100%) will be applied.");
			System.out.println(stringBuilder.toString());
		}

		Product product = orderItem.getProduct();
		double totalOrderItemPriceSingle = product.getPrice() * sizeRateAmount;
		orderItem.setOrderItemPrice(totalOrderItemPriceSingle);
		return totalOrderItemPriceSingle;
	}
	
	/**
	 * calculates the VAT amount of the given total order amount.
	 * 
	 * @param total order amount
	 * @return total order amount with VAT
	 */
	public double calculateTotalOrderAmountVAT(double totalOrderAmount) {
		return totalOrderAmount * getVATRate();
	}
	
	public double getVATRate(boolean decimal) {
		if (decimal) {
			return getVATRate();
		} else {
			return getVATRate() * 100;
		}
	}
	
	protected abstract double getVATRate();
}

