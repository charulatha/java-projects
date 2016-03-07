package com.sainsbury.grocery.sws.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

public class ProductCart {

	private Set<Product> results;
	private BigDecimal total;
	
	public ProductCart() {
		results = new TreeSet<Product>();
		total = BigDecimal.ZERO;
	}
	
	public void addProduct(Product product) {
		results.add(product);
        total = total.add(product.getPrice());
	}

}

