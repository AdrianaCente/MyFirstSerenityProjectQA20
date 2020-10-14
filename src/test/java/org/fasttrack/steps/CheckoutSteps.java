package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.CartPage;
import org.fasttrack.pages.CheckoutPage;

public class CheckoutSteps {
    private CheckoutPage checkoutPage;
    private CartPage cartPage;

    @Step
    public void proceedToCheckout() {
        cartPage.clickCheckout();
    }

    @Step
    public void enterBillingDetails() {
        checkoutPage.setAddress();
        checkoutPage.setCity();
        checkoutPage.getState();
        checkoutPage.setZipCode();
        checkoutPage.getCountry();
        checkoutPage.setTelephone();
    }

    @Step
    public void clickContinue() {
        checkoutPage.clickContinue();
    }

    @Step
    public void clickShippingCheckout() {
        checkoutPage.continueShippingCheckout();
    }

    @Step
    public void clickContinuePayment() {
        checkoutPage.continuePaymentCheckout();
    }

    @Step
    public void clickPlaceOrder() {
        checkoutPage.clickPlaceOrder();
    }

    @Step
    public void verifyOrderCompletion() {
        checkoutPage.verifyPlaceOrder();
    }
}
