package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductDetailsPage extends PageObject {

    @FindBy(css = "a.link-wishlist")
    private WebElementFacade addToWishlistLink;

    @FindBy(css = ".product-view button[title='Add to Cart']")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".toggle-tabs li:last-of-type")
    private WebElementFacade reviewLink;

    @FindBy(css = "#customer-reviews a")
    private WebElementFacade firstReviewLink;

    public void clickAddToWishlist() {
        clickOn(addToWishlistLink);
    }

    public void clickAddToCart() {
        clickOn(addToCartButton);
    }

    public void clickReviewLink() {
        clickOn(reviewLink);
    }
    public void clickFirstReviewLink() {
        clickOn(firstReviewLink);
    }
}
