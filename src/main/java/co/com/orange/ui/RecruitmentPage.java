package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RecruitmentPage extends PageObject {

    public static final Target CONTACT_NUMBER_INPUT = Target.the("Contact number input")
            .locatedBy("//div[3]/div/div[2]/div/div[2]/input");
    public static final Target EMAIL_INPUT = Target.the("Email input")
            .locatedBy("//div[3]/div/div[1]/div/div[2]/input");
    public static final Target FIRST_NAME_INPUT = Target.the("First name input")
            .locatedBy("[name='firstName']");
    public static final Target KEYWORDS_INPUT = Target.the("Keywords input")
            .locatedBy("//div[5]/div/div[1]/div/div[2]/input");
    public static final Target LAST_NAME_INPUT = Target.the("Last name input")
            .locatedBy("[name='lastName']");

    public static final Target VACANCY_DIV = Target.the("Vacancy div")
            .locatedBy("//div[2]/div/div/div/div[2]/div/div/div[1]");


    public static final Target ADD_BUTTON = Target.the("Add button")
            .locatedBy(".oxd-button i");
    public static final Target SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//button[text()=' Save ']");
}
