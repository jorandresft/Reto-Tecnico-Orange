package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class InterviewScheduledPage extends PageObject {

    public static final Target MARK_INTERVIEW_PASSED_BUTTON = Target.the("Mark Interview Passed button")
            .locatedBy("//button[text()=' Mark Interview Passed ']");
}
