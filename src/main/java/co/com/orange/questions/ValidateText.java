package co.com.orange.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateText implements Question<String> {

    private final Target target;

    public ValidateText(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return target.resolveFor(actor).getText();
    }

    public static ValidateText validateText(Target target) {
        return new ValidateText(target);
    }
}
