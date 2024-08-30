package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SaveHirePage extends PageObject {

    public static final Target SAVE_BUTTON = Target.the("Save button hire")
            .locatedBy("//button[text()=' Save ']");
}
