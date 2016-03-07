package com.sainsbury.grocery.sws.main;

import com.sainsbury.grocery.sws.service.GroceryService;

import static com.sainsbury.grocery.sws.util.Constants.PRODUCTS_URL;

public class ConsoleApp {
	public static void main(String[] args) {
		GroceryService groceryService = new GroceryService(PRODUCTS_URL);
		System.out.println(groceryService.displayProductCart());
        System.exit(0);
	}
}
