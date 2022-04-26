package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.makerminds.jcoaching.restaurantapp.exceptions.InvalidOrderItemSizeException;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public class OrderCalculatorKS extends AbstractOrderCalculator {

	private final double VAT_RATE = 0.18;

	public double getSizeRateAmount(OrderItemSize orderItemSize) {
		switch (orderItemSize) {
		case SMALL:
			return 0.7;
		case MEDIUM:
			return 1;
		case LARGE:
			return 1.2;
		case XXL:
			return 1.25;
		default:
			throw new InvalidOrderItemSizeException("No valid order item size: " + orderItemSize);
		}
	}

	@Override
	protected double getVATRate() {
		return VAT_RATE;
	}
}
