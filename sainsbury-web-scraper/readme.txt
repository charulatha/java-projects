sainsbury-web-scraper

Dependencies
===============================================================

Build tool: Maven
JDK: Java 1.6
Third Party APIs: jsoup, gson, junit4, selenium

===============================================================
Maven Commands:

Test and Build:
mvn clean install

Execute Project:
mvn exec:java
(This should produce the expected ouput of the JSON)

PS: - Each webpage has been given 5 secs loading time and hence it take a minute or 2.

===================================================================
Project Explanation:

>Created WebScraper which can be reused to scrape any web pages.
>Product scraper is specific to the product webpage which uses Webscraper to scrape results.
>Model - ProductCart and Product are used to capture the results.
>JsonConvertor another utility to convert any given object to JSON
>Testing:
  >Unit tests created for the utilities - Webscraper and JsonConvertor.
  >Mock tests created for ProductScraper.
  >GroceryService has been intergeration tested end to end with final results.


Observations:

Jsoup was not supporting javascript content and was not producing document, so I had to use Seleium's PhantomJSDriver which had full control over javascript content. Hence I have given 5 secs sleep time for full content to be loaded.

The thread sleep has to be replaced with a eventful wait based on page response for which I didnt find time to complete.




