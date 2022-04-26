package org.makerminds.jcoaching.restaurantapp;

import java.util.Scanner;

import org.makerminds.jcoaching.restaurantapp.controller.LocationManager;
import org.makerminds.jcoaching.restaurantapp.controller.menu.MenuPrinter;
import org.makerminds.jcoaching.restaurantapp.controller.order.OrderManager;
import org.makerminds.jcoaching.restaurantapp.enums.ApplicationMode;
import org.makerminds.jcoaching.restaurantapp.enums.Location;
import org.makerminds.jcoaching.restaurantapp.model.Client;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.Restaurant;
import org.makerminds.jcoaching.restaurantapp.model.order.Order;

public class RestaurantApp {

	private static Location currentLocation;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationMode selectedApplicationMode = getApplicationMode();
		getCurrentLocation();
		validateApplicationMode(selectedApplicationMode);
	}

	private static ApplicationMode getApplicationMode() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Please select an application mode (type number):").append(System.lineSeparator())
				.append("1. " + ApplicationMode.ORDER.name()).append(System.lineSeparator())
				.append("2. " + ApplicationMode.TABLERESERVATION.name());
		System.out.println(stringBuilder.toString());
		int selectedApplicationModeId = scanner.nextInt();
		ApplicationMode selectedApplicationMode = getApplicationModeFromId(selectedApplicationModeId);
		return selectedApplicationMode;
	}

	private static void getCurrentLocation() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Please select your location (type number):").append(System.lineSeparator())
				.append("1. " + Location.KOSOVO.name()).append(System.lineSeparator()).append("2. " + Location.GERMANY.name());
		System.out.println(stringBuilder.toString());
		int selectedLocationId = scanner.nextInt();
		currentLocation = LocationManager.getLocationFromString(selectedLocationId);
	}

	private static void validateApplicationMode(ApplicationMode applicationMode) {
		switch (applicationMode) {
		case ORDER:
			runOrderProcess();
			break;
		case TABLERESERVATION:
			runTableReservationProcess();
			break;
		default:
			throw new IllegalArgumentException("No valid application mode selected!");
		}
	}

	private static ApplicationMode getApplicationModeFromId(int selectedApplicationModeId) {
		switch (selectedApplicationModeId) {
		case 1:
			return ApplicationMode.ORDER;
		case 2:
			return ApplicationMode.TABLERESERVATION;
		default:
			return null;
		}
	}

	private static void runOrderProcess() {
		Restaurant restaurant = new Restaurant("Route 66", "Te Heroinat, Prishtine");
		Client client = new Client("Arbrim Thaci", "+38343123456");

		Menu menu = new Menu();
		menu.initializeMenuProducts();
		MenuPrinter menuPrinter = new MenuPrinter();
		menuPrinter.printMenu(menu);

		OrderManager orderManager = new OrderManager(currentLocation);
		Order order = orderManager.createOrder(menu);
		orderManager.getOrders().add(order);

		orderManager.printOrderInfo(client, restaurant, order);
	}

	private static void runTableReservationProcess() {
	}
}
