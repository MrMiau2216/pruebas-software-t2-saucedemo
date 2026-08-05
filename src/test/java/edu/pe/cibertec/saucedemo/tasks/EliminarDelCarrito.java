package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class EliminarDelCarrito {

    public static Performable producto(String nombreProducto) {
        return Task.where("{0} removes '" + nombreProducto + "' from the cart",
                Click.on(Target.the("Cart icon")
                        .locatedBy(CarritoPage.CART_ICON)),
                Click.on(Target.the("Remove button for " + nombreProducto)
                        .locatedBy(CarritoPage.removeButton(nombreProducto))));
    }

}
