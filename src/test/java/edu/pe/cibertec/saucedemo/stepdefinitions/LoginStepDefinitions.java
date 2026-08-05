package edu.pe.cibertec.saucedemo.stepdefinitions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;
import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.VerificarSesion;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {

    private long tiempoCargaLogin;

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        long tiempoInicio = System.currentTimeMillis();
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
        Page page = BrowseTheWebWithPlaywright.as(OnStage.theActorInTheSpotlight()).getCurrentPage();
        try {
            page.waitForSelector(".inventory_list", new Page.WaitForSelectorOptions().setTimeout(10000));
        } catch (TimeoutError e) {
        }
        long tiempoFin = System.currentTimeMillis();
        tiempoCargaLogin = tiempoFin - tiempoInicio;
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.paginaInventarioVisible()
        );
    }

    @And("the page load time should be greater than {long} milliseconds")
    public void thePageLoadTimeShouldBeGreaterThan(long milisegundos) {
        assertThat(tiempoCargaLogin).isGreaterThan(milisegundos);
    }

    @And("she navigates to the cart page")
    public void sheNavigatesToTheCartPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.irAlCarrito()
        );
    }

    @And("she navigates back to the inventory page")
    public void sheNavigatesBackToTheInventoryPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.volverAlInventario()
        );
    }

    @Then("she should still be logged in")
    public void sheShouldStillBeLoggedIn() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.sesionActiva()
        );
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarSesion.conTitulo(pageTitle)
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

    }

}
