package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class VerificarResumen {

    public static Performable conTotal(String totalEsperado) {
        return Task.where("{0} verifies the item total",
                actor -> actor.should(
                        seeThat(Text.of(CheckoutPage.ITEM_TOTAL), containsString(totalEsperado))
                ));
    }

}
