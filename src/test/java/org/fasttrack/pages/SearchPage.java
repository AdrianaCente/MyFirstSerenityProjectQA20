package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject {
    @FindBy(css = ".page-title h1")
    private WebElementFacade searchText;

    @FindBy(css = ".note-msg")
    private WebElementFacade noItemFound;

    public void verifySearchedText(String searchItem) {
        waitFor(searchText);
        searchText.shouldContainText("SEARCH RESULTS FOR '" + searchItem + "'");
    }

    public void verifySearchedTextWithNoResults() {
        waitFor(noItemFound);
        noItemFound.shouldContainText("Your search returns no results.");
    }
}
