package org.makerminds.jcoaching.restaurantapp.exceptions;

/**
 * custom exception for invalid order item size
 * 
 * @author makerminds
 *
 */
public class InvalidOrderItemSizeException extends RuntimeException {

	public InvalidOrderItemSizeException(String message) {
		super(message);
	}
}
