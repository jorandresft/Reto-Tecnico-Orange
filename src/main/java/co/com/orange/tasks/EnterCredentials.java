package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.LoginPage.*;

public class EnterCredentials implements Task {

    private final String username;
    private final String password;

    public EnterCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(USERNAME_INPUT),
                Enter.theValue(password).into(PASSWORD_INPUT),
                WaitUntil.the(LOGIN_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static EnterCredentials enterCredentials(String username, String password) {
        return Tasks.instrumented(EnterCredentials.class, username, password);
    }
}
