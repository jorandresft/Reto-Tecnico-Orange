package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.ApplicationInitiatedPage.*;
import static co.com.orange.utils.Constants.*;

public class Shortlist implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String textManager = MANAGER_LABEL.resolveFor(actor).getText();
        actor.remember(REMEMBER_MANAGER, textManager);

        String textName = NAME_LABEL.resolveFor(actor).getText();
        actor.remember(REMEMBER_NAME, textName);

        String textVacancy = VACANCY_LABEL.resolveFor(actor).getText();
        actor.remember(REMEMBER_VACANCY, textVacancy);

        actor.attemptsTo(
                WaitUntil.the(SHORTLIST_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(SHORTLIST_BUTTON)
        );
    }

    public static Shortlist clickOnShortListButton() {
        return Tasks.instrumented(Shortlist.class);
    }
}
