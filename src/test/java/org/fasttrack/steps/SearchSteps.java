package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.SearchPage;
import org.junit.Assert;

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

    @Step
    public void verifyWithATitle(String productTitle) {
        Assert.assertTrue("Product not on the page.", searchPage.checkSomeTitle(productTitle));
    }

    @Step
    public void selectSortOption(String sortOption) {
        searchPage.getSortOption(sortOption);
    }

    @Step
    public void checkProductPrice() {
        Assert.assertTrue(searchPage.checkProductPrice());
    }

    @Step
    public void clickOnProductWIthCertainTitle(String productName) {
        searchPage.clickOnProductWithCertainTitle(productName);
    }

    @Step
    public void navigateToSearchedProduct(String searchText, String productName) {
        homePage.open();
        homePage.setSearchInputField(searchText);
        homePage.clickSearchButton();
        searchPage.clickOnProductWithCertainTitle(productName);
    }
}
