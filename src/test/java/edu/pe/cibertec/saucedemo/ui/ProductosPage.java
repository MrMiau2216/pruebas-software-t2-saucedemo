package edu.pe.cibertec.saucedemo.ui;

public class ProductosPage {

    public static final String ORDER_PRODUCT_SELECT = "[data-test='product-sort-container']";
    public static final String FIRST_ITEM_PRICE = "[data-test='inventory-item']:first-child [data-test='inventory-item-price']";
    public static final String LAST_ITEM_PRICE = "[data-test='inventory-item']:last-child [data-test='inventory-item-price']";
    public static final String PRODUCT_NAME = "[data-test='inventory-item-name']";
    public static final String PRODUCT_PRICE = "[data-test='inventory-item-price']";
    public static final String ADD_TO_CART_BUTTON = "#add-to-cart";

    public static String itemNameLink(String nombreProducto) {
        return "text=" + nombreProducto;
    }

}
