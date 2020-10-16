package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.CartPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.ProductDetailsPage;
import org.fasttrack.pages.ProductsListPage;

public class CartSteps {
    private ProductsListPage productsListPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;
    private HomePage homePage;

    @Step
    public void addProductToCart() {
        productsListPage.clickAddToCartButton();
    }

    @Step
    public void checkAddedProducts() {
        cartPage.verifyAddedProduct();
    }

    @Step
    public void addProductToCartFromDetailsPage() {
        productDetailsPage.clickAddToCart();
    }

    @Step
    public void updateQuantityInCart() {
        cartPage.updateQuantity();
        cartPage.clickUpdateButton();
    }

    @Step
    public void navigateToCart() {
        homePage.clickCartLink();
        homePage.clickViewCartLink();
    }

    @Step
    public void verifyUpdatedQty() {
        cartPage.verifyUpdatedQuantity();
    }

    @Step
    public void removeItemFromCart() {
        cartPage.clickRemoveItem();
    }

    @Step
    public void verifyRemovedItem() {
        cartPage.verifyRemoveProduct();
    }

    @Step
    public void checkCartTotal() {
        cartPage.getProductsPrice();
    }

    @Step
    public void checkTotalPrice() {
        cartPage.checkTotalPrice();
    }
}
