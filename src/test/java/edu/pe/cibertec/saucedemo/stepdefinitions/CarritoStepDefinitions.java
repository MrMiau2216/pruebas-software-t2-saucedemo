package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @And("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.producto(productName)
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.producto(productName)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String count) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(CarritoPage.CART_BADGE), equalTo(count))
        );
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContain(String firstProduct, String secondProduct) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart icon").locatedBy(CarritoPage.CART_ICON))
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.ofEach(CarritoPage.CART_ITEM_NAME), containsInAnyOrder(firstProduct, secondProduct))
        );
    }

    @And("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String productName) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.ofEach(CarritoPage.CART_ITEM_NAME), contains(productName))
        );
    }

}
