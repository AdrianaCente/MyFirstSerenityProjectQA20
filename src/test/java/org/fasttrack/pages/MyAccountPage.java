package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage extends PageObject {

    @FindBy(css = ".hello strong")
    private WebElementFacade welcomeMessage;

    @FindBy(css = ".success-msg span")
    private WebElementFacade registerMessage;

    @FindBy(css = "div.block-content li:nth-last-of-type(4) a")
    private WebElementFacade myWishlist;

    public void verifyRegister() {
        registerMessage.shouldContainText("Thank you for registering with Madison Island.");
    }

    public void verifyLoggedIn(String userName){
        welcomeMessage.shouldContainText("Hello, "+userName+"!");
    }

    public void clickMyWishlist() {
        clickOn(myWishlist);
    }
}
