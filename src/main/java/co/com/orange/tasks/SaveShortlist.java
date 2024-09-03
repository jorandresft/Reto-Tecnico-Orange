package co.com.orange.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.orange.ui.SaveShortlistPage.SAVE_BUTTON;

public class SaveShortlist implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SAVE_BUTTON, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(20L).seconds(),
                Click.on(SAVE_BUTTON)
        );
    }

    public static SaveShortlist clickOnSaveShortlistButton() {
        return Tasks.instrumented(SaveShortlist.class);
    }
}
