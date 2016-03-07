package com.sainsbury.grocery.sws.scraper;

import com.sainsbury.grocery.sws.util.Constants;
import com.sainsbury.grocery.sws.util.WebScraper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnit44Runner;

import java.math.BigDecimal;

import static com.sainsbury.grocery.sws.util.Constants.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnit44Runner.class)
public class ProductScraperTest {

    ProductScraper productScraper;

    @Mock
    WebScraper scraper;

    @Before
    public void setup() {
        productScraper = new ProductScraper(scraper);
    }

    @Test
    public void shouldFindProductCount() {
        when(scraper.elementCount()).thenReturn(10);
        Assert.assertThat(productScraper.getProductCount(), is(10));
    }

    @Test
    public void shouldGetTitle() {
        String expected = "Sainsbury's Avocado Ripe & Ready XL Loose 300g";
        when(scraper.scrapeElement(Constants.PRODUCT_TITLE_KEY,0)).thenReturn(expected);
        Assert.assertEquals(expected, productScraper.getTitle(0));
    }

    @Test
    public void shouldGetPrice() {
        BigDecimal expectedPrice = new BigDecimal("1.50");
        when(scraper.scrapeElement(PRODUCT_UNIT_PRICE_KEY,0)).thenReturn("£1.50/unit");
        Assert.assertEquals(expectedPrice, productScraper.getPrice(0));
    }

    @Test
    public void shouldGetContentSize() {
        when(scraper.pageSize(PRODUCTS_URL)).thenReturn(100l);
        Assert.assertEquals(100, productScraper.getSize(PRODUCTS_URL));
    }

    @Test
    public void shouldGetLink() {
        when(scraper.scrapeLink(PRODUCT_LINK_KEY, 0)).thenReturn(PRODUCT_URL);
        Assert.assertEquals(PRODUCT_URL, productScraper.getLink(0));
    }
}
