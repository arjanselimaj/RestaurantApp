package org.makerminds.jcoaching.restaurantapp.controller.menu;

import java.util.Map.Entry;

import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class MenuPrinter {

	public void printMenu(Menu menu) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("---------------MENU-----------------").append(System.lineSeparator());
		for (Entry<Integer, Product> menuEntry : menu.getMenuItems().entrySet()) {
			Product menuItem = menuEntry.getValue();
			stringBuilder.append(menuItem.getProductId()).append(". ")
					.append(menuItem.getName()).append(" | ").append(menuItem.getPrice()).append(" €").append(System.lineSeparator());
		}
		stringBuilder.append("------------------------------------").append(System.lineSeparator());
		System.out.println(stringBuilder.toString());
	}
}
