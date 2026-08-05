package edu.pe.cibertec.saucedemo.tasks;

import com.microsoft.playwright.Page;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion {

    private static final String INVENTORY_LIST = ".inventory_list";
    private static final String CONTINUE_SHOPPING_BUTTON = "[data-test='continue-shopping']";

    public static Performable irAlCarrito() {
        return Task.where("{0} navigates to the cart page",
                Click.on(Target.the("Cart icon")
                        .locatedBy(CarritoPage.CART_ICON)));
    }

    public static Performable volverAlInventario() {
        return Task.where("{0} navigates back to the inventory page",
                Click.on(Target.the("Continue shopping button")
                        .locatedBy(CONTINUE_SHOPPING_BUTTON)));
    }

    public static Performable paginaInventarioVisible() {
        return Task.where("{0} sees the inventory page",
                actor -> {
                    Page page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();
                    assertThat(page.locator(INVENTORY_LIST)).isVisible();
                });
    }

    public static Performable sesionActiva() {
        return Task.where("{0} is still logged in",
                actor -> {
                    Page page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();
                    assertThat(page.locator(INVENTORY_LIST)).isVisible();
                });
    }

    public static Performable conTitulo(String titulo) {
        return Task.where("{0} sees the page title '" + titulo + "'",
                actor -> {
                    Page page = BrowseTheWebWithPlaywright.as(actor).getCurrentPage();
                    assertThat(page.locator(InventoryPage.PAGE_TITLE)).containsText(titulo);
                });
    }

}
