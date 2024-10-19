package starter.SauceDemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class Principal implements Task {

    private String username;
    private String password;

    public Principal(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(username).into("[data-test='username']"),
            Enter.theValue(password).into("[data-test='password']"),
            Click.on("[data-test='login-button']"),
            WaitUntil.the("[data-test='login-button']", WebElementStateMatchers.isNotVisible())
        );
    }

    public static Principal withCredentials(String username, String password) {
        return new Principal(username, password);
    }
}
