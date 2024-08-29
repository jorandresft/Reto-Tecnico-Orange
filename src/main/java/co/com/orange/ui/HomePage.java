package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {

    public static final Target RECRUITMENT_ITEM = Target.the("Recruitment item")
            .locatedBy(".oxd-main-menu >li:nth-child(5)");

    public static final Target CANDIDATE_VALUE = Target.the("Candidate value")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div");
    public static final Target STATUS_VALUE = Target.the("Status values")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div");
    public static final Target VACANCY_VALUE = Target.the("Vacancy value")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div");

    public static final Target CANDIDATE_NAME_INPUT = Target.the("Candidate name input")
            .locatedBy("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div/input");

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .locatedBy("//button[text()=' Search ']");
}
