package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;


    @Steps
    private LoginSteps loginSteps;


    @Test
    public void verifyValidLoginTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials("cosmin@fasttrackit.org","123456");
        loginSteps.clickLogin();
        loginSteps.verifyUserIsLoggedIn("Cosmin Fast");
    }

    @Test
    public void invalidEmailLoginTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials("cosmin@fast.org","123456");
        loginSteps.clickLogin();
        loginSteps.verifyUserIsNotLoggedIn();
    }

    @Test
    public void invalidPasswordLoginTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.enterCredentials("cosmin@fasttrackit.org","1234asd6");
        loginSteps.clickLogin();
        loginSteps.verifyUserIsNotLoggedIn();
    }
}
