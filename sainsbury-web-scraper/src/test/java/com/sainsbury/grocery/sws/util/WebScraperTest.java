package com.sainsbury.grocery.sws.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.sainsbury.grocery.sws.util.Constants.PRODUCTS_URL;
import static com.sainsbury.grocery.sws.util.Constants.PRODUCT_URL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WebScraperTest {

    WebScraper webScraper;

    @Before
	public void setup() {
		webScraper = new WebScraper(PRODUCTS_URL);
		webScraper.loadElements(".product");
	}

	@Test
	public void shouldFindElementCount() {
		Assert.assertThat(webScraper.elementCount(), is(13));
	}

	@Test
	public void shouldScrape() {
		assertEquals("Sainsbury's Avocado Ripe & Ready XL Loose 300g", webScraper.scrape(".productInfo a"));
	}

	@Test
	public void shouldScrapeLink() {
        assertEquals(PRODUCT_URL, webScraper.scrapeLink(".productInfo a"));
	}

	@Test
	public void shouldScrapeElement() {
		assertEquals("£1.50/unit", webScraper.scrapeElement(".pricingAndTrolleyOptions .pricePerUnit",0));
	}

	@Test
	public void shouldFindContentSize() {
		assertNotEquals(0, webScraper.pageSize(PRODUCTS_URL));
	}

}
