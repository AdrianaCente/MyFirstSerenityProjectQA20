package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.SearchSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private SearchSteps searchSteps;

    @Test
    public void searchExistingItem() {
        searchSteps.enterSearchValue("pearl");
        searchSteps.clickSearch();
        searchSteps.verifySearchText("PEARL");
    }

    @Test
    public void searchUnexistentItem() {
        searchSteps.enterSearchValue("afg");
        searchSteps.clickSearch();
        searchSteps.verifySearchWithNoResults();
    }
}
