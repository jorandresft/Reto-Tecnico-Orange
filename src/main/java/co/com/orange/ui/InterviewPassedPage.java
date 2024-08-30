package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class InterviewPassedPage extends PageObject {

    public static final Target OFFER_JOB_BUTTON = Target.the("Offer job button")
            .locatedBy("//button[text()=' Offer Job ']");
}
