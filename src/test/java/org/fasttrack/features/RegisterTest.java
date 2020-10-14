package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.RegisterSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private RegisterSteps registerSteps;

    @Test
    public void verifyValidRegisterTest() {
        registerSteps.registerUser("Ema", "Didi", "Thomson", "ten@yahoo.com", "1234567", "1234567");
        registerSteps.verifyRegisteredUser();
    }

    @Test
    public void verifyIncompleteMandatoryRegisterTest() {
        registerSteps.registerUser("", "Didi", "Don", "emt@yahoo.com", "1234567", "1234567");
        registerSteps.verifyRegisterWithIncompleteFields();
    }

    @Test
    public void verifyRegisterWithInvalidPasswordTest() {
        registerSteps.registerUser("Dan", "Didi", "gg", "emt@yahoo.com", "22", "22");
        registerSteps.verifyPassword();
    }
}
