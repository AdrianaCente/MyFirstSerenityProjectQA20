package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ReviewPage extends PageObject {

    @FindBy(css = "#Price_2")
    private WebElementFacade price;

    @FindBy(css = "#Value_3")
    private WebElementFacade value;

    @FindBy(css = "#Quality_3")
    private WebElementFacade quality;

    @FindBy(css = "#review_field")
    private WebElementFacade reviewField;

    @FindBy(css = "#summary_field")
    private WebElementFacade summaryField;

    @FindBy(css = "#nickname_field")
    private WebElementFacade nicknameField;

    @FindBy(css = "button[title='Submit Review']")
    private WebElementFacade submitButton;

    @FindBy(css = ".success-msg span")
    private WebElementFacade reviewMessage;

    public void clickPrice() {
        waitFor(price);
        clickOn(price);
    }

    public void clickValue() {
        waitFor(value);
        clickOn(value);
    }

    public void clickQuality() {
        waitFor(quality);
        clickOn(quality);
    }

    public void setReviewField() {
        typeInto(reviewField, "Some review");
    }

    public void setSummaryField() {
        typeInto(summaryField, "Some summary");
    }

    public void setNicknameField() {
        typeInto(nicknameField, "Some nickname");
    }

    public void clickSubmit() {
        clickOn(submitButton);
    }

    public void verifyReview() {
        reviewMessage.shouldContainText("Your review has been accepted for moderation.");
    }
}
