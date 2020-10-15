package org.fasttrack.pages;

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

    public void verifySearchedText(String searchItem) {
        for (WebElementFacade item : listItems) {
            String titleString = item.find(By.cssSelector("h2.product-name a")).getAttribute("title").toLowerCase();
            if (titleString.contains(searchItem)) break;
        }
    }

    public void verifySearchedTextWithNoResults() {
        waitFor(noItemFound);
        noItemFound.shouldContainText("Your search returns no results.");
    }
}
