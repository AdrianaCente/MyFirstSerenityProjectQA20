package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.pages.ProductDetailsPage;
import org.fasttrack.pages.ReviewPage;

public class ReviewSteps {
    private ProductDetailsPage productDetailsPage;
    private ReviewPage reviewPage;

    @Step
    public void navigateToReviewPage() {
        productDetailsPage.clickReviewLink();
        productDetailsPage.clickFirstReviewLink();
    }

    @Step
    public void enterReviewDetails(String review, String summary, String nickname) {
        reviewPage.clickPrice();
        reviewPage.clickValue();
        reviewPage.clickQuality();
        reviewPage.setReviewField(review);
        reviewPage.setSummaryField(summary);
        reviewPage.setNicknameField(nickname);
    }

    @Step
    public void clickSubmit() {
        reviewPage.clickSubmit();
    }

    @Step
    public void verifyReview() {
        reviewPage.verifyReview();
    }
}
