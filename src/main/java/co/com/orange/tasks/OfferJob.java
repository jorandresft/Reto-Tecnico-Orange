package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.InterviewPassedPage.OFFER_JOB_BUTTON;

public class OfferJob implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(OFFER_JOB_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Click.on(OFFER_JOB_BUTTON)
        );
    }

    public static OfferJob offerJob() {
        return Tasks.instrumented(OfferJob.class);
    }
}
