package org.makerminds.jcoaching.restaurantapp.controller.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class AbstractOrderCalculatorTest {

	private Menu menu = new Menu();
	AbstractOrderCalculator orderCalculatorMock = new AbstractOrderCalculator() {

		@Override
		public double getSizeRateAmount(OrderItemSize orderItemSize) {
			return 1.0;
		}

		@Override
		protected double getVATRate() {
			return 0.12;
		}
	};

	@Test
	public void testCalcuateTotalOrderItemPrice() {
		Product hamburger = menu.getMenuItems().get(100);
		OrderItem orderItem = new OrderItem(hamburger, OrderItemSize.MEDIUM, 2);

		double totalOrderItemPrice = orderCalculatorMock.calcuateTotalOrderItemPrice(orderItem);

		Assertions.assertEquals(9.0, totalOrderItemPrice);
		Assertions.assertEquals(4.5, orderItem.getOrderItemPrice());
	}

	@Test
	public void testCalculateTotalOrderAmount() {
		Product hamburger = menu.getMenuItems().get(100);
		Product sandwich = menu.getMenuItems().get(102);
		Product cocaCola = menu.getMenuItems().get(200);
		Product iceCream = menu.getMenuItems().get(300);

		OrderItem hamburgerOrderItem = new OrderItem(hamburger, OrderItemSize.MEDIUM, 1);
		OrderItem sandwichOrderItem = new OrderItem(sandwich, OrderItemSize.MEDIUM, 1);
		OrderItem cocaColaOrderItem = new OrderItem(cocaCola, OrderItemSize.MEDIUM, 2);
		OrderItem iceCreamOrderItem = new OrderItem(iceCream, OrderItemSize.MEDIUM, 2);

		Order order = new Order();
		order.getOrderItems().add(hamburgerOrderItem);
		order.getOrderItems().add(sandwichOrderItem);
		order.getOrderItems().add(cocaColaOrderItem);
		order.getOrderItems().add(iceCreamOrderItem);

		double totalOrderPrice = orderCalculatorMock.calculateTotalOrderAmount(order);

		Assertions.assertEquals(12.0, totalOrderPrice);
	}
	
	@Test
	public void testCalculateTotalOrderAmountVAT() {
		double totalOrderAmountVAT = orderCalculatorMock.calculateTotalOrderAmountVAT(12.0);
		Assertions.assertEquals(1.44, totalOrderAmountVAT);
	}
}
