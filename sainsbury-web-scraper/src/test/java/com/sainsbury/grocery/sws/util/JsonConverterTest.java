package com.sainsbury.grocery.sws.util;

import com.sainsbury.grocery.sws.model.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JsonConverterTest {

    JsonConverter converter = new JsonConverter();

    @Test
    public void shouldConstructJson() throws Exception {
        Product product = new Product("Title", BigDecimal.ONE,new Long(100), "Desc");
        assertThat("{\n" +
                "  \"title\": \"Title\",\n" +
                "  \"size\": \"100kb\",\n" +
                "  \"unit_price\": 1,\n" +
                "  \"description\": \"Desc\"\n" +
                "}", is(converter.constructJson(product)));
    }
}
