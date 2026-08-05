package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.ProductosPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class VerificarDetalle {

    public static Performable delProducto(String nombreProducto) {
        return Task.where("{0} click on product '" + nombreProducto + "'",
                Click.on(Target.the("Product " + nombreProducto)
                        .locatedBy(ProductosPage.itemNameLink(nombreProducto))));
    }

}
