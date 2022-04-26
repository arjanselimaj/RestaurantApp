package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.enums.Location;
import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItemSize;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class OrderManager {

	private ArrayList<Order> orders = new ArrayList<>();
	private IOrderCalculator orderCalculator;
	private Location location;

	public OrderManager(Location location) {
		this.location = location;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public Order createOrder(Menu menu) {
		Order order = new Order();
		order.setVatRate(getOrderCalculator().getVATRate(false));
		addOrderItem(order, menu.getMenuItems().get(100), 1, OrderItemSize.XXL);
		addOrderItem(order, menu.getMenuItems().get(101), 1, OrderItemSize.MEDIUM);
		addOrderItem(order, menu.getMenuItems().get(200), 2, OrderItemSize.LARGE);
		addOrderItem(order, menu.getMenuItems().get(201), 3, OrderItemSize.SMALL);
		updateOrderAmounts(order);
		return order;
	}

	private void addOrderItem(Order order, Product product, int quantity, OrderItemSize orderItemSize) {
		OrderItem orderItemMeal = createOrderItemMeal(product, orderItemSize, quantity);
		order.getOrderItems().add(orderItemMeal);
	}

	private void updateOrderAmounts(Order order) {
		double totalOrderAmount = getOrderCalculator().calculateTotalOrderAmount(order);
		order.setTotalOrderAmount(totalOrderAmount);

		double totalOrderAmountVAT = getOrderCalculator().calculateTotalOrderAmountVAT(totalOrderAmount);
		order.setTotalOrderAmountVAT(totalOrderAmountVAT);

		double totalOrderAmountWithVAT = totalOrderAmount + totalOrderAmountVAT;
		order.setTotalOrderAmountWithVAT(totalOrderAmountWithVAT);
	}

	private OrderItem createOrderItemMeal(Product product, OrderItemSize orderItemSize, int quantity) {
		return new OrderItem(product, orderItemSize, quantity);
	}

	private IOrderCalculator getOrderCalculator() {
		if (orderCalculator == null) {
			orderCalculator = getOrderCalculator(location);
		}

		return orderCalculator;
	}

	private IOrderCalculator getOrderCalculator(Location currentLocation) {
		if (currentLocation == null) {
			throw new IllegalArgumentException("Current location must not be null.");
		} else {
			switch (currentLocation) {
			case KOSOVO:
				return new OrderCalculatorKS();
			case GERMANY:
				return new OrderCalculatorGER();
			default:
				throw new IllegalArgumentException("Current location is invalid.");
			}
		}
	}

	public void printOrderInfo(Client client, Restaurant restaurant, Order order) {
		OrderPrinter orderPrinter = new OrderPrinter();
		orderPrinter.printOrderInfo(client, restaurant, order, location);
	}
}
