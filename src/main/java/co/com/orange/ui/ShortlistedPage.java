package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ShortlistedPage extends PageObject {
    public static final Target SCHEDULE_INTERVIEW_BUTTON = Target.the("Schedule interview button")
            .locatedBy(".orangehrm-recruitment-actions button:nth-child(2)");
}
