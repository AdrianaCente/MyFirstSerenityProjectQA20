package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ProductsListPage extends PageObject {

    @FindBy(css = "div.category-products > ul.products-grid > li")
    private List<WebElementFacade> productsList;

    @FindBy(css = "div.category-products > ul.products-grid > li:first-of-type a")
    private WebElementFacade firstListProduct;

    @FindBy(css = "div.category-products > ul.products-grid > li:first-of-type .link-wishlist")
    private WebElementFacade wishlistLinkGallery;

    @FindBy(css = "div.category-products > ul.products-grid > li:first-of-type button")
    private WebElementFacade addToCartButton;

    public WebElementFacade getProductFromList(int index) {
        WebElementFacade productsListItem = productsList.get(index);
        return productsListItem;
    }

    public void clickRequiredItem(int index) {
        clickOn(getProductFromList(index));
    }

    public void addToWishlistFromGallery() {
        clickOn(wishlistLinkGallery);
    }

    public void clickAddToCartButton() {
        clickOn(addToCartButton);
    }
}
