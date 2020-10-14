package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.LoginPage;
import org.fasttrack.pages.MyAccountPage;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickAccountLink();
        homePage.clickLoginLink();
    }

    @Step
    public void enterCredentials(String email, String password){
        loginPage.setEmailField(email);
        loginPage.setPasswordField(password);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLogin();
    }

    @Step
    public void verifyUserIsLoggedIn(String userName){
        myAccountPage.verifyLoggedIn(userName);
    }

    @Step
    public void verifyUserIsNotLoggedIn(){
        loginPage.verifyErrorMessage();
    }

    @Step
    public void logIn(String user, String pass){
        navigateToLoginPage();
        enterCredentials(user,pass);
        clickLogin();
    }

}
