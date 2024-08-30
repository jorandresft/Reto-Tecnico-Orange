package co.com.orange.tasks;

import co.com.orange.models.CandidateModel;
import co.com.orange.utils.ArrowDown;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.RecruitmentPage.*;
import static co.com.orange.utils.Constants.*;
import static co.com.orange.utils.Time.waiting;

public class RecruitmentForm implements Task {

    private final CandidateModel candidateModel;

    public RecruitmentForm(CandidateModel candidateModel) {
        this.candidateModel = candidateModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(candidateModel.getFirstName()).into(FIRST_NAME_INPUT),
                Enter.theValue(candidateModel.getLastName()).into(LAST_NAME_INPUT),
                Click.on(VACANCY_DIV),
                ArrowDown.arrowDown(candidateModel.getVacancy()),
                Enter.theValue(candidateModel.getEmail()).into(EMAIL_INPUT),
                Enter.theValue(candidateModel.getContactNumber()).into(CONTACT_NUMBER_INPUT),
                Scroll.to(KEYWORDS_INPUT),
                Enter.theValue(candidateModel.getKeywords()).into(KEYWORDS_INPUT),
                WaitUntil.the(SAVE_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(SAVE_BUTTON)
        );
        waiting(TIME_SHORT);
    }

    public static RecruitmentForm fillInfo(CandidateModel candidateModel) {
        return Tasks.instrumented(RecruitmentForm.class, candidateModel);
    }
}
