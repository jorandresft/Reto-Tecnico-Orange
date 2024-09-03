package co.com.orange.tasks;

import co.com.orange.models.InterviewModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.orange.ui.ScheduleInterviewPage.*;
import static co.com.orange.utils.Constants.*;
import static co.com.orange.utils.Time.waiting;

public class InterviewForm implements Task {

    private final InterviewModel interviewModel;

    public InterviewForm(InterviewModel interviewModel) {
        this.interviewModel = interviewModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String textManager = actor.recall(REMEMBER_MANAGER);

        actor.attemptsTo(
                WaitUntil.the(INTERVIEW_TITLE_INPUT, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Click.on(INTERVIEW_TITLE_INPUT),
                Enter.theValue(interviewModel.getInterviewTitle()).into(INTERVIEW_TITLE_INPUT),
                Click.on(INTERVIEWER_INPUT),
                Enter.theValue(textManager).into(INTERVIEWER_INPUT)
        );

        waiting(TIME_SHORT);

        actor.attemptsTo(
                Hit.the(Keys.ARROW_DOWN).into(INTERVIEWER_INPUT),
                Hit.the(Keys.ENTER).into(INTERVIEWER_INPUT),
                Enter.theValue(interviewModel.getDate()).into(DATE_INPUT),
                WaitUntil.the(SAVE_BUTTON, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Click.on(SAVE_BUTTON)
        );
    }

    public static InterviewForm fillInfoInterview(InterviewModel interviewModel) {
        return Tasks.instrumented(InterviewForm.class, interviewModel);
    }
}
