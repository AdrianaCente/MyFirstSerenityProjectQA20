package org.fasttrack.pages;

import io.cucumber.java.sl.In;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageObject {
    @FindBy(css = ".page-title h1")
    private WebElementFacade searchText;

    @FindBy(css = ".note-msg")
    private WebElementFacade noItemFound;

    @FindBy(css = "div.toolbar + ul.products-grid li.item")
    private List<WebElementFacade> listItems;

    @FindBy(css = ".category-products > .toolbar select[title='Sort By']:first-of-type")
    private WebElementFacade sortSelect;

    @FindBy(css = ".products-grid li.item.last")
    private List<WebElementFacade> resultedItems;

    public void verifySearchedText(String searchItem) {
        for (WebElementFacade item : listItems) {
            String titleString = item.find(By.cssSelector("h2.product-name a")).getAttribute("title").toLowerCase();
            if (titleString.contains(searchItem)) break;
        }
    }

    public boolean checkSomeTitle(String productTitle) {
        for (WebElementFacade item : listItems) {
            if (item.find(By.cssSelector("h2.product-name a")).getText().equals(productTitle)) {
                return true;
            }
        }
        return false;
    }

    public void verifySearchedTextWithNoResults() {
        waitFor(noItemFound);
        noItemFound.shouldContainText("Your search returns no results.");
    }

    public void getSortOption(String optionSort) {
        sortSelect.selectByVisibleText(optionSort);
    }

    public int formatStringValue(List<WebElementFacade> resultedItems, int position) {
        String stringPrice = resultedItems.get(position).find(By.cssSelector("[id^='product-price']")).getText().replaceAll(",",".");
        Double doubleFormatPrice = Double.valueOf(stringPrice.substring(0, stringPrice.length() - 4).trim());
        Integer castPriceInteger = doubleFormatPrice.intValue();
        return castPriceInteger;
    }

    public boolean checkProductPrice() {
        Integer castItemOne = formatStringValue(resultedItems, 0);
        Integer castLastItem = formatStringValue(resultedItems, resultedItems.size() - 1);

        if (castItemOne <= castLastItem) {
            return  true;
        }
        return false;
    }

    public void clickOnProductWithCertainTitle(String productName) {
        for (WebElementFacade item : listItems) {
            if (item.find(By.cssSelector("h2.product-name a")).getText().equals(productName)) {
                clickOn(item.find(By.cssSelector("a.product-image")));
                break;
            }
        }
    }
}
