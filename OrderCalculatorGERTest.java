package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public class OrderCalculatorGERTest {

	OrderCalculatorGER orderCalculatorGER = new OrderCalculatorGER();

	@Test
	public void testGetVATRate() {
		double vatRate = orderCalculatorGER.getVATRate();
		Assertions.assertEquals(0.19, vatRate);
	}

	@Test
	public void testGetSizeRateAmounts() {
		double sizeRateAmountSmall = orderCalculatorGER.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.8, sizeRateAmountSmall);

		double sizeRateAmountMedium = orderCalculatorGER.getSizeRateAmount(OrderItemSize.MEDIUM);
		Assertions.assertEquals(1.0, sizeRateAmountMedium);

		double sizeRateAmountLarge = orderCalculatorGER.getSizeRateAmount(OrderItemSize.LARGE);
		Assertions.assertEquals(1.25, sizeRateAmountLarge);

		double sizeRateAmountXXL = orderCalculatorGER.getSizeRateAmount(OrderItemSize.XXL);
		Assertions.assertEquals(1.3, sizeRateAmountXXL);
	}
}
