package org.makerminds.jcoaching.restaurantapp.model.product;

public class Meal extends Product {

	String description;

	public Meal(String name, int productId, double price) {
		setName(name);
		setProductId(productId);
		setPrice(price);
	}

	public Meal(String name, int productId, double price, String description) {
		this(name, productId, price);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}