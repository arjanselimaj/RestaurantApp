package org.makerminds.jcoaching.restaurantapp.exceptions;

/**
 * custom exception for invalid order item size
 * 
 * @author makerminds
 *
 */
public class InvalidMenuFileException extends RuntimeException {

	public InvalidMenuFileException(String message) {
		super(message);
	}
}
