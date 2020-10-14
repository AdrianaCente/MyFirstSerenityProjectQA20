package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("http://testfasttrackit.info/selenium-test/customer/account/create/")
public class RegisterPage extends PageObject {

    @FindBy(id = "firstname")
    private WebElementFacade firstName;

    @FindBy(id = "middlename")
    private WebElementFacade middleName;

    @FindBy(id = "lastname")
    private WebElementFacade lastName;

    @FindBy(id = "email_address")
    private WebElementFacade email;

    @FindBy(id = "password")
    private WebElementFacade password;

    @FindBy(id = "confirmation")
    private WebElementFacade confirmationPassword;

    @FindBy(id = "is_subscribed")
    private WebElementFacade subscribedNewsletter;

    @FindBy(css = "button[title='Register']")
    private WebElementFacade registerButton;

    @FindBy(css = ".validation-advice")
    private List<WebElementFacade> mandatoryMessage;

    @FindBy(id = "advice-validate-password-password")
    private WebElementFacade passwordErrorMsg;

    public void setFirstName(String fName) {
        typeInto(firstName, fName);
    }

    public void setMiddleName(String mName) {
        typeInto(middleName, mName);
    }

    public void setLastName(String lName) {
        typeInto(lastName, lName);
    }

    public void setEmail(String userEmail) {
        typeInto(email, userEmail);
    }

    public void setPassword(String userPassword) {
        typeInto(password, userPassword);
    }

    public void setPasswordConfirmation(String userPasswordConfirmation) {
        typeInto(confirmationPassword, userPasswordConfirmation);
    }

    public void checkIsSubscribed() {
        clickOn(subscribedNewsletter);
    }

    public void clickRegister() {
        clickOn(registerButton);
    }

    public void verifyMandatoryFields() {
        for (WebElementFacade element : mandatoryMessage) {
            element.shouldContainOnlyText("This is a required field.");
        }
    }

    public void verifyPassword() {
        passwordErrorMsg.shouldContainText("Please enter 6 or more characters without leading or trailing spaces.");
    }
}
