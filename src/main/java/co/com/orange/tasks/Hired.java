package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.HiredPage.STATUS_LABEL;
import static co.com.orange.ui.HomePage.RECRUITMENT_ITEM;
import static co.com.orange.utils.Constants.REMEMBER_STATUS;

public class Hired implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(STATUS_LABEL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds()
        );

        String textStatus = STATUS_LABEL.resolveFor(actor).getText();
        actor.remember(REMEMBER_STATUS, textStatus);

        actor.attemptsTo(
                WaitUntil.the(RECRUITMENT_ITEM, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Click.on(RECRUITMENT_ITEM)
        );
    }

    public static Hired getHiredStatus() {
        return Tasks.instrumented(Hired.class);
    }
}
