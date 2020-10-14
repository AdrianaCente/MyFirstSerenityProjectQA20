package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.MyAccountPage;
import org.fasttrack.pages.RegisterPage;

public class RegisterSteps {
    private HomePage homePage;
    private RegisterPage registerPage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToRegisterPage() {
        homePage.open();
        homePage.clickAccountLink();
        homePage.clickRegisterLink();
    }

    @Step
    public void enterRegisterInformation(String firstName, String middleName, String lastName, String email, String password, String confirmation) {
        registerPage.setFirstName(firstName);
        registerPage.setMiddleName(middleName);
        registerPage.setLastName(lastName);
        registerPage.setEmail(email);
        registerPage.setPassword(password);
        registerPage.setPasswordConfirmation(confirmation);
        registerPage.checkIsSubscribed();
    }

    @Step
    public void clickRegister() {
        registerPage.clickRegister();
    }

    @Step
    public void verifyRegisteredUser() {
        myAccountPage.verifyRegister();
    }

    @Step
    public void verifyRegisterWithIncompleteFields() {
        registerPage.verifyMandatoryFields();
    }

    @Step
    public void verifyPassword() {
        registerPage.verifyPassword();
    }

    @Step
    public void registerUser(String firstName, String middleName, String lastName, String email, String password, String confirmation) {
        navigateToRegisterPage();
        enterRegisterInformation(firstName, middleName, lastName, email, password, confirmation);
        clickRegister();
    }
}
