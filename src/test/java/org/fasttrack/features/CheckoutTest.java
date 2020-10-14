package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.pages.CartPage;
import org.fasttrack.steps.CartSteps;
import org.fasttrack.steps.CheckoutSteps;
import org.fasttrack.steps.LoginSteps;
import org.fasttrack.steps.WishlistSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private WishlistSteps wishlistSteps;

    @Steps
    private CheckoutSteps checkoutSteps;

    @Test
    public void enterBillingInformation() {
        loginSteps.logIn("eight@yahoo.com", "1234567");
        wishlistSteps.navigateToProductListPage(driver);
        cartSteps.addProductToCart();
        checkoutSteps.proceedToCheckout();
        checkoutSteps.enterBillingDetails();
        checkoutSteps.clickContinue();
        checkoutSteps.clickShippingCheckout();
        checkoutSteps.clickContinuePayment();
        checkoutSteps.clickPlaceOrder();
        checkoutSteps.verifyOrderCompletion();
    }
}
