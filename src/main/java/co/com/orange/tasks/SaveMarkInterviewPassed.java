package co.com.orange.tasks;

import co.com.orange.ui.ScheduleInterviewPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.SaveMarkInterviewPassedPage.SAVE_BUTTON;

public class SaveMarkInterviewPassed implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SAVE_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Click.on(ScheduleInterviewPage.SAVE_BUTTON)
        );
    }

    public static SaveMarkInterviewPassed saveMarkInterviewPassed() {
        return Tasks.instrumented(SaveMarkInterviewPassed.class);
    }
}
