package starter.SauceDemo;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class Navegar{
    /**
     * An action that opens the browser on the Wikipedia home page
     */
    public static Performable toTheHomePage() {
        return Open.url("https://saucedemo.com");
    }
}
