package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SaveMarkInterviewPassedPage extends PageObject {

    public static final Target SAVE_BUTTON = Target.the("Save button mark interview passed")
            .locatedBy("//button[text()=' Save ']");
}
