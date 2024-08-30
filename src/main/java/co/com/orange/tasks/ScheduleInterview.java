package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.ShortlistedPage.SCHEDULE_INTERVIEW_BUTTON;

public class ScheduleInterview implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SCHEDULE_INTERVIEW_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(SCHEDULE_INTERVIEW_BUTTON)
        );
    }

    public static ScheduleInterview scheduleInterview() {
        return Tasks.instrumented(ScheduleInterview.class);
    }
}
