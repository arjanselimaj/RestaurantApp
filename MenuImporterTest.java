package org.makerminds.jcoaching.restaurantapp.controller.order;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.makerminds.jcoaching.restaurantapp.controller.menu.MenuImporter;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class MenuImporterTest {
	
	private MenuImporter menuImporter;
	private final String MENU_FILE_PATH = "/menu-test.txt";
	
	@Test
	public void testImportMenu() {
		menuImporter = new MenuImporter();
		Menu importedMenu = menuImporter.importMenu(MENU_FILE_PATH);
		HashMap<Integer, Product> menuItems = importedMenu.getMenuItems();
		Assertions.assertEquals(8, menuItems.size());
	}
}
