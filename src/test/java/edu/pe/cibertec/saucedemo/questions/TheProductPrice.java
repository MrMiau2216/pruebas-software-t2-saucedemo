package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.ProductosPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class TheProductPrice {

    public static Question<String> ofFirstItem() {
        return Text.of(Target.the("First product price")
                .locatedBy(ProductosPage.FIRST_ITEM_PRICE));
    }
    public static Question<String> ofLastItem() {
        return Text.of(Target.the("Last product price")
                .locatedBy(ProductosPage.LAST_ITEM_PRICE));
    }
}
