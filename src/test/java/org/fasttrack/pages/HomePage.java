package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://testfasttrackit.info/selenium-test/")
public class HomePage extends PageObject {

    @FindBy(css = ".skip-account .label")
    private WebElementFacade accountLink;

    @FindBy(css = "a[title='Log In']")
    private WebElementFacade loginLink;

    @FindBy(css = "a[title='Register']")
    private WebElementFacade registerLink;

    @FindBy(css = "a[title='Log Out']")
    private WebElementFacade logoutLink;

    @FindBy(css = ".welcome-msg")
    private WebElementFacade logoutMessage;

    @FindBy(id = "search")
    private WebElementFacade searchInputField;

    @FindBy(css = "button[title='Search']")
    private WebElementFacade searchButton;

    @FindBy(css = "li.nav-3 > a.level0")
    private WebElementFacade saleMenu;

    @FindBy(css = "li.nav-3-2 > a")
    private WebElementFacade saleMenSubmenu;

    @FindBy(css = "a.skip-cart")
    private WebElementFacade cartIcon;

    @FindBy(css = "a.cart-link")
    private WebElementFacade cartViewLink;


    public void clickAccountLink(){
        waitFor(accountLink);
        clickOn(accountLink);
    }


    public void clickLoginLink(){
        clickOn(loginLink);
    }

    public void clickRegisterLink() {
        clickOn(registerLink);
    }

    public void clickLogOutLink() {
        clickOn(logoutLink);
    }

    public void verifyLogoutMessage() {
        logoutMessage.shouldContainOnlyText("WELCOME");
    }

    public void setSearchInputField(String textInput) {
        typeInto(searchInputField, textInput);
    }

    public void clickSearchButton() {
        clickOn(searchButton);
    }

    public void hoverMenu(WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(saleMenu).perform();
    }

    public void clickSubmenu() {
        clickOn(saleMenSubmenu);
    }

    public void clickCartLink() {
        clickOn(cartIcon);
    }

    public void clickViewCartLink() {
        clickOn(cartViewLink);
    }
}
