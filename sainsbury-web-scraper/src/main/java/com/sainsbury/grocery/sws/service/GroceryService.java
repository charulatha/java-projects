package com.sainsbury.grocery.sws.service;

import com.sainsbury.grocery.sws.model.ProductCart;
import com.sainsbury.grocery.sws.scraper.ProductScraper;
import com.sainsbury.grocery.sws.util.JsonConverter;

public class GroceryService {

	ProductScraper sainsburyScraper;
	JsonConverter convertor;
	
	public GroceryService (String url) {
		sainsburyScraper = new ProductScraper(url);
		convertor = new JsonConverter();
	}
	
	public ProductCart getProductCart() {
		return sainsburyScraper.scrapeProductCart();
	}

	public String displayProductCart() {
		return convertor.constructJson(getProductCart());
	}
}
