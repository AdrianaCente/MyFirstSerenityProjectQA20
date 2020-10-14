package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;

@DefaultUrl("http://testfasttrackit.info/selenium-test/checkout/cart/")
public class CartPage extends PageObject {
    private Integer updateValue = 3;

    @FindBy(css =".success-msg span")
    private WebElementFacade addToCartSuccessMessage;

    @FindBy(css ="#shopping-cart-table > tbody > tr:first-of-type .product-cart-actions input[title='Qty']")
    private WebElementFacade productQuantity;

    @FindBy(css ="#shopping-cart-table > tbody > tr:first-of-type .product-cart-actions button")
    private WebElementFacade updateQuantityButton;

    @FindBy(css ="#shopping-cart-table > tbody > tr:first-of-type .product-cart-remove .btn-remove2")
    private WebElementFacade removeButton;

    @FindBy(css =".page-title h1")
    private WebElementFacade pageTitle;

    @FindBy(css =".cart-totals-wrapper button[title='Proceed to Checkout']")
    private WebElementFacade checkoutButton;

    public void verifyAddedProduct() {
        addToCartSuccessMessage.shouldContainText("Pearl Stud Earrings was added to your shopping cart.");
    }

    public void updateQuantity() {
        typeInto(productQuantity, updateValue.toString());
    }

    public void clickUpdateButton() {
        clickOn(updateQuantityButton);
    }

    public void verifyUpdatedQuantity() {
        Assert.assertEquals(productQuantity.getValue(), updateValue.toString());
    }

    public void clickRemoveItem() {
        clickOn(removeButton);
    }

    public void verifyRemoveProduct() {
        pageTitle.shouldContainText("SHOPPING CART IS EMPTY");
    }

    public void clickCheckout() {
        clickOn(checkoutButton);
    }
}
