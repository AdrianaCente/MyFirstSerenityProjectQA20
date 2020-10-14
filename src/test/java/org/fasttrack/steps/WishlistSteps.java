package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.*;
import org.openqa.selenium.WebDriver;

public class WishlistSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductsListPage productsListPage;
    private ProductDetailsPage productDetailsPage;
    private WishlistPage wishlistPage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToProductListPage(WebDriver driver) {
        homePage.open();
        homePage.hoverMenu(driver);
        homePage.clickSubmenu();
    }

    @Step
    public void navigateToDetailsPage(int index) {
        productsListPage.clickRequiredItem(index);
    }

    @Step
    public void addProductToWishlist() {
        productDetailsPage.clickAddToWishlist();
    }

    @Step
    public void verifyAddProductToWishlist() {
        wishlistPage.verifyAddedProductToWishList();
    }

    @Step
    public void verifyLoginBeforeWishlist() {
        loginPage.verifyLoginRequirement();
    }

    @Step
    public void addToWishlistFromGalleryProducts() {
        productsListPage.addToWishlistFromGallery();
    }
}
