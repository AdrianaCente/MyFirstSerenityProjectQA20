package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.LoginPage;

public class LogoutSteps {
    private HomePage homePage;

    @Step
    public void clickLogout() {
        homePage.clickAccountLink();
        homePage.clickLogOutLink();
    }

    @Step
    public void verifyLogoutUser() {
        homePage.verifyLogoutMessage();
    }
}
