package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.ReviewSteps;
import org.fasttrack.steps.WishlistSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ReviewTest {

    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private WishlistSteps wishlistSteps;

    @Steps
    private ReviewSteps reviewSteps;

    @Test
    public void addProductReview() {
        wishlistSteps.navigateToProductListPage(driver);
        wishlistSteps.navigateToDetailsPage(0);
        reviewSteps.navigateToReviewPage();
        reviewSteps.enterReviewDetails("Test review", "Test summary", "Test nickname");
        reviewSteps.clickSubmit();
        reviewSteps.verifyReview();
    }
}
