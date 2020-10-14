package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://testfasttrackit.info/selenium-test/customer/account/login/")
public class LoginPage extends PageObject {

    @FindBy(id ="email")
    private WebElementFacade emailField;

    @FindBy(id = "pass")
    private WebElementFacade passwordField;

    @FindBy(id = "send2")
    private WebElementFacade loginButton;

    @FindBy(css =".error-msg span")
    private WebElementFacade errorMessage;

    @FindBy(css =".page-title h1")
    private WebElementFacade addToWishlistLogin;


    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }

    public void clickLogin(){
        clickOn(loginButton);
    }

    public void verifyErrorMessage(){
        errorMessage.shouldContainOnlyText("Invalid login or password.");
    }

    public void verifyLoginRequirement(){
        addToWishlistLogin.shouldContainText("LOGIN OR CREATE AN ACCOUNT");
    }
}
