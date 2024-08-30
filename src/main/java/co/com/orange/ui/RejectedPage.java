package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RejectedPage extends PageObject {

    public static final Target REJECT_STATUS = Target.the("Schedule interview button")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[1]/p");
}
