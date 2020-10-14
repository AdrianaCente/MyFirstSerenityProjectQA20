package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.SearchPage;

public class SearchSteps {
    private HomePage homePage;
    private SearchPage searchPage;

    @Step
    public void enterSearchValue(String searchText) {
        homePage.open();
        homePage.setSearchInputField(searchText);
    }

    @Step
    public void clickSearch() {
        homePage.clickSearchButton();
    }

    @Step
    public void verifySearchText(String searchText) {
        searchPage.verifySearchedText(searchText);
    }

    @Step
    public void verifySearchWithNoResults() {
        searchPage.verifySearchedTextWithNoResults();
    }
}
