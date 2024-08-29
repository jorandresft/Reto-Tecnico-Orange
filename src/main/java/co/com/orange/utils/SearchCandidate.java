package co.com.orange.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.orange.ui.HomePage.*;
import static co.com.orange.utils.Constants.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SearchCandidate implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String textName = theActorCalled(ACTOR).recall(REMEMBER_NAME);
        String[] str = textName.split(" ");

        actor.attemptsTo(
                Click.on(CANDIDATE_NAME_INPUT),
                Enter.theValue(str[0]).into(CANDIDATE_NAME_INPUT)
        );

        Time.waiting(TIME_SHORT);

        actor.attemptsTo(
                Hit.the(Keys.ARROW_DOWN).into(CANDIDATE_NAME_INPUT),
                Hit.the(Keys.ENTER).into(CANDIDATE_NAME_INPUT),
                Click.on(SEARCH_BUTTON),
                WaitUntil.the(STATUS_VALUE, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20L).seconds(),
                Scroll.to(STATUS_VALUE)
        );
    }

    public static SearchCandidate search() {
        return Tasks.instrumented(SearchCandidate.class);
    }
}
