package com.sainsbury.grocery.sws.service;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static com.sainsbury.grocery.sws.util.Constants.PRODUCTS_URL;

public class GroceryServiceTest {
	
	GroceryService groceryService;

    String EXPECTED = "{\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Avocado Ripe & Ready XL Loose 300g\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 1.50,\n" +
            "      \"description\": \"Avocados\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Avocado, Ripe & Ready x2\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 1.80,\n" +
            "      \"description\": \"Avocados\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Avocados, Ripe & Ready x4\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 3.20,\n" +
            "      \"description\": \"Avocados\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 1.50,\n" +
            "      \"description\": \"Conference\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Kiwi Fruit, Ripe & Ready x4\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 1.50,\n" +
            "      \"description\": \"Kiwi\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Kiwi Fruit, SO Organic x4\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 1.00,\n" +
            "      \"description\": \"Kiwi\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Mango, Ripe & Ready x2\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 2.00,\n" +
            "      \"description\": \"by Sainsbury's Ripe and Ready Mango\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Nectarines, Ripe & Ready x4\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 3.00,\n" +
            "      \"description\": \"Ripe & ready\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Papaya, Ripe (each) Only £1.25: Save 25p\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 1.25,\n" +
            "      \"description\": \"Papaya\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Peaches Ripe & Ready x4\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 3.50,\n" +
            "      \"description\": \"Peach\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Plums Ripe & Ready, Taste the Difference x5\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 2.50,\n" +
            "      \"description\": \"Plums\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Ripe & Ready Golden Plums x6\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 2.00,\n" +
            "      \"description\": \"Plums\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Sainsbury's Ripe & Ready Red Pears x4\",\n" +
            "      \"size\": \"189kb\",\n" +
            "      \"unit_price\": 1.50,\n" +
            "      \"description\": \"Sweet & Juicy Blush Pears\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"total\": 26.25\n" +
            "}";

    String expected;

	@Before
	public void setup() throws UnsupportedEncodingException {
		groceryService = new GroceryService(PRODUCTS_URL);
        expected = new String(EXPECTED.getBytes("UTF-8"), "UTF-8");
	}
	
	@Test
	public void shouldDisplayProductCart(){
        String productCartJson = groceryService.displayProductCart();
        Assert.assertEquals(expected, productCartJson);
	}

}

