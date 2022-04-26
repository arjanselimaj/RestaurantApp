package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;

public class OrderCalculatorKSTest {
	
	OrderCalculatorKS orderCalculatorKS = new OrderCalculatorKS();
	
	@Test
	public void testGetVATRate() {
		double vatRate = orderCalculatorKS.getVATRate();
		Assertions.assertEquals(0.18, vatRate);
	}
	
	@Test
	public void testGetSizeRateAmounts() {
		double sizeRateAmountSmall = orderCalculatorKS.getSizeRateAmount(OrderItemSize.SMALL);
		Assertions.assertEquals(0.7, sizeRateAmountSmall);
		
		double sizeRateAmountMedium = orderCalculatorKS.getSizeRateAmount(OrderItemSize.MEDIUM);
		Assertions.assertEquals(1.0, sizeRateAmountMedium);
		
		double sizeRateAmountLarge = orderCalculatorKS.getSizeRateAmount(OrderItemSize.LARGE);
		Assertions.assertEquals(1.2, sizeRateAmountLarge);
		
		double sizeRateAmountXXL = orderCalculatorKS.getSizeRateAmount(OrderItemSize.XXL);
		Assertions.assertEquals(1.25, sizeRateAmountXXL);
	}
}
