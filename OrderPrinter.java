package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.ArrayList;

import org.makerminds.jcoaching.restaurantapp.enums.Location;
import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;
import org.makerminds.jcoaching.restaurantapp.model.order.OrderItem;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

/**
 * controller to manage print operations for orders.
 * 
 * @author makerminds
 *
 */
public class OrderPrinter {

	private StringBuilder stringBuilder = new StringBuilder();
	
	public void printOrderInfo(Client client, Restaurant restaurant, Order order, Location location) {
		printOrderInfoHeader(client);
		ArrayList<OrderItem> orderProducts = order.getOrderItems();
		orderProducts.forEach(o -> printOrderItemInfo(o));
		printOrderInfoFooter(restaurant, order, location);
	}

	private void printOrderItemInfo(OrderItem orderItem) {
		Product product = orderItem.getProduct();
		double totalOrderItemPrice = orderItem.getOrderItemPrice() * orderItem.getQuantity();
		stringBuilder.append(orderItem.getQuantity()).append("x | ").append(product.getProductId()).append(". ")
				.append(product.getName()).append(" | ").append(orderItem.getOrderItemPrice()).append(" | ")
				.append(totalOrderItemPrice).append(" €").append(System.lineSeparator());
	}

	private void printOrderInfoHeader(Client client) {
		stringBuilder.append("Order from ").append(client.getName()).append(": ").append(System.lineSeparator());
		stringBuilder.append("------------------------------------").append(System.lineSeparator());
	}

	private void printOrderInfoFooter(Restaurant restaurant, Order order, Location location) {
		stringBuilder.append("------------------------------------").append(System.lineSeparator())
				.append("The total price of the order is: ").append(System.lineSeparator()).append("SUB TOTAL: ")
				.append(order.getTotalOrderAmount()).append(" €.").append(System.lineSeparator()).append("VAT ").append((int)order.getVatRate())
				.append("%: ").append(order.getTotalOrderAmountVAT()).append(" €.").append(System.lineSeparator())
				.append("TOTAL: ").append(order.getTotalOrderAmountWithVAT()).append(" €.").append(System.lineSeparator())
				.append(restaurant.getName()).append(" in ").append(restaurant.getAddress()).append(System.lineSeparator())
				.append("------------------------------------");
		System.out.println(stringBuilder.toString());
	}
}
