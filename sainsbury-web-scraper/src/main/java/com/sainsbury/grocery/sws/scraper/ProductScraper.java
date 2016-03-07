package com.sainsbury.grocery.sws.scraper;

import com.sainsbury.grocery.sws.model.Product;
import com.sainsbury.grocery.sws.model.ProductCart;
import com.sainsbury.grocery.sws.util.Constants;
import com.sainsbury.grocery.sws.util.WebScraper;

import java.math.BigDecimal;

public class ProductScraper implements Constants {

    WebScraper scraper;
	
	public ProductScraper(String url) {
		scraper = new WebScraper(url);
		scraper.loadElements(PRODUCT_KEY);
	}

    public ProductScraper(WebScraper scraper) {
		this.scraper = scraper;
	}
	
	public ProductCart scrapeProductCart () {
		ProductCart cart = new ProductCart();
				
		for(int i=0; i < getProductCount(); i++) {
			cart.addProduct(getProduct(i));
		}
		return cart;
	}
	
	
	public int getProductCount(){
		return scraper.elementCount();
	}
	
	public Product getProduct(int index) {
		
		String 		title 		= getTitle(index);
		BigDecimal 	price 		= getPrice(index);
		String 		productUrl 	= getLink(index);
		long 		pageSize  	= getSize(productUrl);
		String 		desc 		= getDescription(productUrl);

		return new Product (title, price, pageSize, desc);
	}
	
	public String getTitle(int index){
		return scraper.scrapeElement(PRODUCT_TITLE_KEY,index);
	}
	
	public String getLink(int index){
		return scraper.scrapeLink(PRODUCT_LINK_KEY, index);
	}
	
	public BigDecimal getPrice(int index){
		String productPrice = scraper.scrapeElement(PRODUCT_UNIT_PRICE_KEY,index);
        productPrice = productPrice.replace("£","");
		productPrice = productPrice.replace("/","");
		productPrice = productPrice.replace("unit","");
		return new BigDecimal(productPrice);
	}
	
	public long getSize(String url){
		return scraper.pageSize(url);
	}
	
	public String getDescription(String productUrl){
		return new WebScraper(productUrl).scrape(PRODUCT_DESC_KEY);
	}
	
}
