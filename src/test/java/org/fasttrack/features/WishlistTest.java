package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.fasttrack.steps.WishlistSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WishlistTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private WishlistSteps wishlistSteps;

    @Test
    public void addProductToWishListFromDetailsPage() {
        loginSteps.logIn("ema@yahoo.com", "1234567");
        wishlistSteps.navigateToProductListPage(driver);
        wishlistSteps.navigateToDetailsPage(0);
        wishlistSteps.addProductToWishlist();
        wishlistSteps.verifyAddProductToWishlist();
    }

    @Test
    public void addProductToWishListFromProductsGallery() {
        loginSteps.logIn("ema@yahoo.com", "1234567");
        wishlistSteps.navigateToProductListPage(driver);
        wishlistSteps.addToWishlistFromGalleryProducts();
        wishlistSteps.verifyAddProductToWishlist();
    }

    @Test
    public void addProductToWishListWithoutLogin() {
        wishlistSteps.navigateToProductListPage(driver);
        wishlistSteps.navigateToDetailsPage(0);
        wishlistSteps.addProductToWishlist();
        wishlistSteps.verifyLoginBeforeWishlist();
    }
}
