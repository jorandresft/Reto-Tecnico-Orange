package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.HomePage.RECRUITMENT_ITEM;
import static co.com.orange.ui.RejectedPage.REJECT_STATUS;
import static co.com.orange.utils.Constants.REMEMBER_STATUS;

public class Rejected implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(REJECT_STATUS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds()
        );

        String textStatus = REJECT_STATUS.resolveFor(actor).getText();
        actor.remember(REMEMBER_STATUS, textStatus);

        actor.attemptsTo(
                WaitUntil.the(RECRUITMENT_ITEM, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Click.on(RECRUITMENT_ITEM)
        );
    }

    public static Rejected getRejectedStatus() {
        return Tasks.instrumented(Rejected.class);
    }
}
