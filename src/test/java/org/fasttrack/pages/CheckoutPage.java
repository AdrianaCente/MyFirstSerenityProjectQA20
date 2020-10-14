package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutPage extends PageObject {

    @FindBy(css = "#billing-new-address-form [title='Street Address']")
    private WebElementFacade address;

    @FindBy(css = "#billing-new-address-form [title='City']")
    private WebElementFacade city;

    @FindBy(css = "#billing-new-address-form select[title='Country']")
    private WebElementFacade country;

    @FindBy(css = "#billing-new-address-form select[title='State/Province']")
    private WebElementFacade state;

    @FindBy(css = "#billing-new-address-form [title='Zip/Postal Code']")
    private WebElementFacade zipCode;

    @FindBy(css = "#billing-new-address-form [title='Telephone']")
    private WebElementFacade telephone;

    @FindBy(css = "#billing-buttons-container button[title='Continue']")
    private WebElementFacade continueButtonBilling;

    @FindBy(css = "#checkout-step-shipping_method button")
    private WebElementFacade continueButtonShipping;

    @FindBy(css = "#payment-buttons-container button.button")
    private WebElementFacade continueButtonPayment;

    @FindBy(css = ".gift-messages h3")
    private WebElementFacade giftOptions;

    @FindBy(css = "#checkout-payment-method-load label")
    private WebElementFacade paymentOptions;

    @FindBy(css = "button[title='Place Order']")
    private WebElementFacade placeOrderButton;

    @FindBy(css = ".page-title + h2")
    private WebElementFacade orderMessage;

    public void setAddress() {
        typeInto(address, "HAHA Street, no.1");
    }

    public void setCity() {
        typeInto(city, "Rome");
    }

    public void getCountry() {
        country.selectByValue("US");
    }

    public void getState() {
        state.selectByValue("24");
    }

    public void setZipCode() {
        typeInto(zipCode, "556622");
    }

    public void setTelephone() {
        typeInto(telephone, "45897632");
    }

    public void clickContinue() {
        clickOn(continueButtonBilling);
    }

    public void continueShippingCheckout() {
        waitFor(continueButtonShipping);
        clickOn(continueButtonShipping);
    }

    public void continuePaymentCheckout() {
        waitFor(continueButtonPayment);
        clickOn(continueButtonPayment);
    }

    public void clickPlaceOrder() {
        waitFor(placeOrderButton);
        clickOn(placeOrderButton);
    }

    public void verifyPlaceOrder() {
        waitFor(orderMessage);
        orderMessage.shouldContainText("THANK YOU FOR YOUR PURCHASE!");
    }
}
