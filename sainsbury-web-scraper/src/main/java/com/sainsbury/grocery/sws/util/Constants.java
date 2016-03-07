package com.sainsbury.grocery.sws.util;

public interface Constants {

    String PRODUCTS_URL = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?listView=true" +
                            "&orderBy=FAVOURITES_FIRST&parent_category_rn=12518&top_category=12518" +
                            "&langId=44&beginIndex=0&pageSize=20&catalogId=10137&searchTerm=" +
                            "&categoryId=185749&listId=&storeId=10151&promotionId=#langId=44" +
                            "&storeId=10151&catalogId=10137&categoryId=185749&parent_category_rn=12518" +
                            "&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=" +
                            "&beginIndex=0&hideFilters=true";

    String PRODUCT_URL = "http://www.sainsburys.co.uk/shop/gb/groceries/ripe---ready/sainsburys-avocado-xl-pinkerton-loose-300g";

    public static final String PRODUCT_KEY = ".product";
    public static final String PRODUCT_TITLE_KEY = ".productInfo";
    public static final String PRODUCT_LINK_KEY = ".productInfo a";
    public static final String PRODUCT_UNIT_PRICE_KEY = ".pricingAndTrolleyOptions .pricePerUnit";
    public static final String PRODUCT_DESC_KEY = "div.productText p";
}
