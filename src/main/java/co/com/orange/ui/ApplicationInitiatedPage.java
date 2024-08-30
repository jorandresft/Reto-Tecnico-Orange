package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ApplicationInitiatedPage extends PageObject {

    public static final Target REJECT_BUTTON = Target.the("Reject button")
            .locatedBy(".orangehrm-recruitment-actions button:nth-child(1)");
    public static final Target SHORTLIST_BUTTON = Target.the("Shortlist button")
            .locatedBy(".orangehrm-recruitment-actions button:nth-child(2)");

    public static final Target MANAGER_LABEL = Target.the("Manager label")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[3]/div/div[2]/p");
    public static final Target NAME_LABEL = Target.the("Name label")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[1]/div/div[2]/p");
    public static final Target VACANCY_LABEL = Target.the("Vacancy label")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div[1]/form/div[1]/div[2]/div/div[2]/p");
}
