package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://testfasttrackit.info/selenium-test/wishlist/")
public class WishlistPage extends PageObject {

    @FindBy(css = "#wishlist-table tbody>.last")
    private WebElementFacade lastItemAddedToWishlist;

    @FindBy(css = ".success-msg span")
    private WebElementFacade addToWishListMessage;

    public String getProductName() {
        return lastItemAddedToWishlist.getAttribute("title");
    }

    public void verifyAddedProductToWishList() {
        addToWishListMessage.shouldContainText(getProductName() + " has been added to your wishlist.");
    }
}
