package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.HomePage.RECRUITMENT_ITEM;
import static co.com.orange.ui.RecruitmentPage.ADD_BUTTON;

public class Recruitment implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RECRUITMENT_ITEM, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(RECRUITMENT_ITEM),
                WaitUntil.the(ADD_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(ADD_BUTTON)
        );
    }

    public static Recruitment clickOnRecruitmentItemAndAddButton() {
        return Tasks.instrumented(Recruitment.class);
    }
}
