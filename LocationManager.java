package org.makerminds.jcoaching.restaurantapp.controller;

import org.makerminds.jcoaching.restaurantapp.enums.Location;

public class LocationManager {

	public static Location getLocationFromString(int locationId) {
		switch (locationId) {
		case 1:
			return Location.KOSOVO;
		case 2:
			return Location.GERMANY;
		default:
			throw new IllegalArgumentException("No location could be found for given location paramter.");
		}
	}
}
