package edu.pe.cibertec.saucedemo.ui;

public class CarritoPage {

    public static final String CART_ICON = "#shopping_cart_container";
    public static final String CART_BADGE = "[data-test='shopping-cart-badge']";
    public static final String CART_ITEM_NAME = "[data-test='inventory-item-name']";

    public static String addToCartButton(String nombreProducto) {
        return ".inventory_item:has-text('" + nombreProducto + "') button";
    }

    public static String removeButton(String nombreProducto) {
        return ".cart_item:has-text('" + nombreProducto + "') button";
    }

}
