package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.ApplicationInitiatedPage.*;
import static co.com.orange.ui.ApplicationInitiatedPage.VACANCY_LABEL;
import static co.com.orange.utils.Constants.*;

public class rejectCandidate implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        String textName = NAME_LABEL.resolveFor(actor).getText();
        actor.remember(REMEMBER_NAME, textName);

        String textVacancy = VACANCY_LABEL.resolveFor(actor).getText();
        actor.remember(REMEMBER_VACANCY, textVacancy);

        actor.attemptsTo(
                WaitUntil.the(REJECT_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(REJECT_BUTTON)
        );
    }

    public static rejectCandidate shortlistReject() {
        return Tasks.instrumented(rejectCandidate.class);
    }
}
