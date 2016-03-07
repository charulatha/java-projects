package com.sainsbury.grocery.sws.model;

import java.math.BigDecimal;

public class Product implements Comparable<Product> {

	private String title;
	private String size;
	private BigDecimal unit_price;
	private String description;
	
	public Product(String title, BigDecimal price, Long size, String description) {
		this.title=title;
		this.unit_price = price;
		this.size = Long.toString(size) + "kb";
		this.description= description;
	}

	public String getTitle() {
		return title;
	}

	public BigDecimal getPrice() {
		return unit_price;
	}

	public String getSize() {
		return size;
	}

	public String getDescription() {
		return description;
	}

    @Override
    public int compareTo(Product product) {
        return this.title.compareTo(product.getTitle());
    }
}

