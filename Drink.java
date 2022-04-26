package org.makerminds.jcoaching.restaurantapp.model.product;

public class Drink extends Product {
	
	boolean sugarFree;
	
	public Drink(String name, int productId, double price, boolean sugarFree) {
		setName(name);
		setProductId(productId);
		setPrice(price);
		this.sugarFree = sugarFree;
	}

	public boolean isSugarFree() {
		return sugarFree;
	}

	public void setSugarFree(boolean sugarFree) {
		this.sugarFree = sugarFree;
	}
}