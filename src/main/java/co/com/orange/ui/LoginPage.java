package co.com.orange.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target PASSWORD_INPUT = Target.the("Password input")
            .locatedBy("[name='password']");
    public static final Target USERNAME_INPUT = Target.the("Username input")
            .locatedBy("[name='username']");

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("//button[text()=' Login ']");
}
