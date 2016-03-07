package com.sainsbury.grocery.sws.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebScraper {

    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0";
    public static final int WAIT_SECS = 5;

    Document document;
    Elements elements;

    public WebScraper(String url) {
        try {
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setJavascriptEnabled(true);
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "userAgent", USER_AGENT);
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
                    "--web-security=false",
                    "--ssl-protocol=any",
                    "--ignore-ssl-errors=true",
                    "--webdriver-loglevel=NONE"
            });
            capability.setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    "src/main/resources/phantomjs.exe"
            );

            WebDriver driver = new PhantomJSDriver(capability);
            //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get(url);

            Thread.sleep(WAIT_SECS * 1000);
            String html_content = driver.getPageSource();
            driver.close();

            document = Jsoup.parse(html_content);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int elementCount() {
        return elements.size();
    }

    public String scrape(String scrapeString) {
        return document.select(scrapeString).get(0).ownText();
    }

    public String scrapeElement(String scrapeString, int index) {
        return elements.get(index).select(scrapeString).text();
    }

    public String scrapeLink(String scrapeString, int index) {
        return elements.get(index).select(scrapeString).attr("href");
    }

    public String scrapeLink(String scrapeString) {
        return scrapeLink(scrapeString, 0);
    }

    public void loadElements(String scrapeString) {
        elements = document.select(scrapeString);
    }

    public long pageSize(String url) {
        try {
            URLConnection page = new URL(url).openConnection();
            return page.getContentLength();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
