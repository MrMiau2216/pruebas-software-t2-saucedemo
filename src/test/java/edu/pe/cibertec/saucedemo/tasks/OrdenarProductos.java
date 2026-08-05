package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.ProductosPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.SelectFromOptions;

public class OrdenarProductos {

    public static Performable por(String opcion) {
        return Task.where("{0} ordena los productos por '" + opcion + "'",
                SelectFromOptions.byVisibleText(opcion)
                        .from(Target.the("").locatedBy(ProductosPage.ORDER_PRODUCT_SELECT))

        );
    }

}
