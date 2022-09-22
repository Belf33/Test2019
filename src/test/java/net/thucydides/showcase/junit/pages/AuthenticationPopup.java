package net.thucydides.showcase.junit.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.junit.utils.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPopup extends PageObject {

    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginHeader;

    @FindBy(xpath = "//input[@data-testid='email-phone-number-auth-input']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@data-testid='email-phone-number-auth-input']/../../div[2]")
    WebElement emailErrorMessageWrapper;

    @FindBy(xpath = "//button[@data-testid='auth-continue-button']")
    WebElement continueButton;

    public boolean isSighUpPopupVisible() {
        return element(loginHeader).isCurrentlyVisible();
    }

    public void enterEmail(String email) {
        element(emailInput).type(email);
    }

    public String getInvalidEmailWrapperText() {
        Helpers.waitFor(2, () -> !element(emailErrorMessageWrapper).getText().equals(""),
                "invalid password message didn't displayed");

        return element(emailErrorMessageWrapper).getText();
    }

    public void clickContinueButton() {
        element(continueButton).click();
    }
}
