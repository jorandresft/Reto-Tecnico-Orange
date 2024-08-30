package co.com.orange.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.orange.ui.RecruitmentPage.VACANCY_DIV;

public class ArrowDown implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrowDown.class);

    private final String vacancy;

    public ArrowDown(String vacancy) {
        this.vacancy = vacancy;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int cant = 0;

        switch (vacancy) {
            case "Junior Account Assistant":
                cant = 1;
                break;
            case "Payroll Administrator":
                cant = 2;
                break;
            case "Sales Representative":
                cant = 3;
                break;
            case "Senior QA Lead":
                cant = 4;
                break;
            case "Senior Support Specialist":
                cant = 5;
                break;
            case "Software Engineer":
                cant = 6;
                break;
            case "test":
                cant = 7;
                break;
            default:
                LOGGER.info("Option not defined");
        }

        for (int i = 1; i <= cant; i++) {
            actor.attemptsTo(
                    Hit.the(Keys.ARROW_DOWN).into(VACANCY_DIV)
            );
        }
        actor.attemptsTo(
                Hit.the(Keys.ENTER).into(VACANCY_DIV)
        );
    }

    public static ArrowDown arrowDown(String vacancy) {
        return Tasks.instrumented(ArrowDown.class, vacancy);
    }
}
