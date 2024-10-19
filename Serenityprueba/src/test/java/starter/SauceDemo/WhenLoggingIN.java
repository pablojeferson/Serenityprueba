package starter.SauceDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import starter.wikipedia.DisplayedArticle;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingIN {

    @CastMember(name = "Pablo")
    Actor pablo;

    @Test
    void shouldDisplaySauceLabsBackpackWhenSearchingByKeyword() {
        pablo.attemptsTo(Navegar.toTheHomePage());
        pablo.attemptsTo(
        new Principal("standard_user", "secret_sauce"),
        Click.on("[data-test='add-to-cart-sauce-labs-bike-light']"),
        Click.on("[data-test='shopping-cart-link']"),
        Click.on("[data-test='checkout']"),
        Enter.theValue("Pablo").into("[data-test='firstName']"),
        Enter.theValue("Mamani Suyco").into("[data-test='lastName']"),
        Enter.theValue("0523123123").into("[data-test='postalCode']"),
        Click.on("[data-test='continue']"),
        Click.on("[data-test='finish']"),
        WaitUntil.the("[data-test='finish']", WebElementStateMatchers.isNotVisible())
        );
    }
}