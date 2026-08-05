package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class AgregarAlCarrito {

    public static Performable producto(String nombreProducto) {
        return Task.where("{0} adds '" + nombreProducto + "' to the cart",
                Click.on(Target.the("Add to cart button for " + nombreProducto)
                        .locatedBy(CarritoPage.addToCartButton(nombreProducto))));
    }

}
