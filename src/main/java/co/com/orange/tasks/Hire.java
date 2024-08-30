package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.JobOfferedPage.HIRE_BUTTON;

public class Hire implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HIRE_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Click.on(HIRE_BUTTON)
        );
    }

    public static Hire hire() {
        return Tasks.instrumented(Hire.class);
    }
}
