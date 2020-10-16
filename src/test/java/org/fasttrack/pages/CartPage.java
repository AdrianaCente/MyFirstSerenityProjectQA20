package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

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

    @FindBy(css ="#shopping-cart-table > tbody > tr.last h2 a ")
    private WebElementFacade productName;

    @FindBy(css ="#shopping-cart-table > tbody > tr")
    private List<WebElementFacade> productsList;

    @FindBy(css ="#shopping-cart-totals-table tfoot")
    private WebElementFacade totalPrice;

    @FindBy(css ="#shopping-cart-totals-table tbody")
    private WebElementFacade totalTax;

    public void verifyAddedProduct() {
        String cartMessage = addToCartSuccessMessage.getText();
        String itemName = productName.getAttribute("innerHTML");
        Assert.assertTrue(cartMessage.contains(itemName));
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

    public int formatStringValue(WebElementFacade resultedItem, String selectorValue) {
        String stringPrice = resultedItem.find(By.cssSelector(selectorValue)).getText().replaceAll(",", ".");
        Double doubleFormatPrice = Double.valueOf(stringPrice.substring(0, stringPrice.length() - 4).trim());
        Integer castPriceInteger = doubleFormatPrice.intValue();
        return castPriceInteger;
    }

    public int getProductsPrice() {
        int totalSum = 0;
        for (WebElementFacade item : productsList) {
            Integer intPrice = formatStringValue(item, ".product-cart-total span.price");
            totalSum += intPrice;
        }
        return totalSum;
    }

    public void checkTotalPrice() {
        int totalPriceWithTaxes = formatStringValue(totalPrice, ".a-right span.price");
        int totalTaxes = formatStringValue(totalTax, "tr:last-of-type .a-right span.price");
        int gradTotal = getProductsPrice() + totalTaxes;
        Assert.assertEquals(totalPriceWithTaxes, gradTotal);
    }
}
