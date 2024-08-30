package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.InterviewScheduledPage.MARK_INTERVIEW_PASSED_BUTTON;

public class MarkInterviewPassed implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MARK_INTERVIEW_PASSED_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(MARK_INTERVIEW_PASSED_BUTTON)
        );
    }

    public static MarkInterviewPassed markInterviewPassed() {
        return Tasks.instrumented(MarkInterviewPassed.class);
    }
}
