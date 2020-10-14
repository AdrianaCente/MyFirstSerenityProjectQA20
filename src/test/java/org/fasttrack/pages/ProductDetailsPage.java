package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductDetailsPage extends PageObject {

    @FindBy(css = "a.link-wishlist")
    private WebElementFacade addToWishlistLink;

    @FindBy(css = ".product-view button[title='Add to Cart']")
    private WebElementFacade addToCartButton;

    public void clickAddToWishlist() {
        clickOn(addToWishlistLink);
    }

    public void clickAddToCart() {
        clickOn(addToCartButton);
    }
}
