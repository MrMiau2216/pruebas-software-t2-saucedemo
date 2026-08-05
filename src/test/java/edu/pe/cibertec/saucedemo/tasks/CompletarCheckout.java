package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class CompletarCheckout {

    public static Performable conDatos(String nombre, String apellido, String codigoPostal) {
        return Task.where("{0} fills in checkout information",
                Click.on(Target.the("Cart icon")
                        .locatedBy(CheckoutPage.CART_ICON)),
                Click.on(Target.the("Checkout button")
                        .locatedBy(CheckoutPage.CHECKOUT_BUTTON)),
                Enter.theValue(nombre)
                        .into(Target.the("First name field")
                                .locatedBy(CheckoutPage.FIRST_NAME_FIELD)),
                Enter.theValue(apellido)
                        .into(Target.the("Last name field")
                                .locatedBy(CheckoutPage.LAST_NAME_FIELD)),
                Enter.theValue(codigoPostal)
                        .into(Target.the("Postal code field")
                                .locatedBy(CheckoutPage.POSTAL_CODE_FIELD)),
                Click.on(Target.the("Continue button")
                        .locatedBy(CheckoutPage.CONTINUE_BUTTON)));
    }

    public static Performable finalizarOrden() {
        return Task.where("{0} finishes the order",
                Click.on(Target.the("Finish button")
                        .locatedBy(CheckoutPage.FINISH_BUTTON)));
    }

}
