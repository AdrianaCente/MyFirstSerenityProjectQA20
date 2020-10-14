package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.CartSteps;
import org.fasttrack.steps.LoginSteps;
import org.fasttrack.steps.WishlistSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private WishlistSteps wishlistSteps;

    @Test
    public void addToCartFromGalleryPageTest(){
        loginSteps.logIn("ema@yahoo.com", "1234567");
        wishlistSteps.navigateToProductListPage(driver);
        cartSteps.addProductToCart();
        cartSteps.checkAddedProducts();
    }

    @Test
    public void addToCartFromDetailsPageTest(){
        loginSteps.logIn("ema@yahoo.com", "1234567");
        wishlistSteps.navigateToProductListPage(driver);
        wishlistSteps.navigateToDetailsPage(0);
        cartSteps.addProductToCartFromDetailsPage();
        cartSteps.checkAddedProducts();
    }

    @Test
    public void updateQuantityInCart() {
        loginSteps.logIn("ema@yahoo.com", "1234567");
        cartSteps.navigateToCart();
        cartSteps.updateQuantityInCart();
        cartSteps.verifyUpdatedQty();
    }

    @Test
    public void removeProductFromCart(){
        loginSteps.logIn("ema@yahoo.com", "1234567");
        cartSteps.navigateToCart();
        cartSteps.removeItemFromCart();
        cartSteps.verifyRemovedItem();
    }
}


