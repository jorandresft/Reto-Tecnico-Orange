package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class JobOfferedPage extends PageObject {

    public static final Target HIRE_BUTTON = Target.the("Hire button")
            .locatedBy("//button[text()=' Hire ']");
}
