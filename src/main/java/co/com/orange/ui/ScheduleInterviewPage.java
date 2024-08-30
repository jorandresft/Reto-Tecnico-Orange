package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ScheduleInterviewPage extends PageObject {

    public static final Target DATE_INPUT = Target.the("Date input")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div/input");
    public static final Target INTERVIEW_TITLE_INPUT = Target.the("Interview title input")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    public static final Target INTERVIEWER_INPUT = Target.the("Interviewer input")
            .locatedBy(".oxd-input-group div > input:nth-child(2)");

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//button[text()=' Save ']");
}
