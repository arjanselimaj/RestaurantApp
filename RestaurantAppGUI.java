package org.makerminds.jcoaching.restaurantapp.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.makerminds.jcoaching.restaurantapp.controller.menu.MenuImporter;
import org.makerminds.jcoaching.restaurantapp.model.Menu;
import org.makerminds.jcoaching.restaurantapp.model.product.Product;

public class RestaurantAppGUI {

	private JFrame frame = new JFrame();
	private JTable table;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private final String MENU_FILE_PATH = "/pizza-menu.txt";
	private boolean fromFile = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantAppGUI window = new RestaurantAppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RestaurantAppGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("RestaurantApp (JCoaching)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		prepareMenuDataTable();
		table = new JTable(defaultTableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Restaurant Menu"));
		
		//frame.getContentPane().add(scrollPane);
		
		JPanel panel= new JPanel();
		JButton switchMenuButton = createSwitchMenuButton(panel);
		panel.add(switchMenuButton);
		panel.add(scrollPane);
		
		frame.getContentPane().add(panel);
	}

	private void prepareMenuDataTable() {
		String[] header = {"Id", "Name", "Price"};
		Menu menu = getMenu();
		String[][] menuListArray = createMenuListArray(menu);
		defaultTableModel.setDataVector(menuListArray, header);
	}

	private Menu getMenu() {
		Menu menu;
		if(fromFile) {
			MenuImporter importer = new MenuImporter();
			menu = importer.importMenu(MENU_FILE_PATH);
		} else {
			menu = new Menu(true);
		}
		return menu;
	}

	private JButton createSwitchMenuButton(JPanel panel) {
		JButton switchMenuButton = new JButton("Switch Menu");
		switchMenuButton.setBounds(103, 115, 91, 36);
		switchMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fromFile = fromFile == false ? true : false;
				prepareMenuDataTable();
			}
		});
		return switchMenuButton;
	}

	private String[][] createMenuListArray(Menu menu) {
		HashMap<Integer, Product> menuItems = menu.getMenuItems();

		String[][] menuListArray = new String[menuItems.size()][3];
		
		int i = 0;
		for(Entry<Integer, Product> menuItem : menuItems.entrySet()) {
			Product product = menuItem.getValue();
			menuListArray[i][0] = Integer.toString(product.getProductId());
			menuListArray[i][1] = product.getName();
			menuListArray[i][2] = Double.toString(product.getPrice());
			i++;
		}
		
		return menuListArray;
	}

}
