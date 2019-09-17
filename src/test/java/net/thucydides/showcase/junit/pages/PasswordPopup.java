package net.thucydides.showcase.junit.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.junit.utils.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPopup extends PageObject {

    @FindBy(xpath = "//div[. = 'Enter your password']")
    WebElement titleWrapper;

    @FindBy(xpath = "//input[@data-testid='auth-password-input']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@data-testid='auth-login-button']")
    WebElement logInButton;

    @FindBy(xpath = "//input[@data-testid='auth-password-input']/../../div[2]")
    WebElement passwordErrorMessage;

    public String getPageTitle() {
        return element(titleWrapper).getText();
    }

    public void enterPassword(String password) {
        element(passwordInput).type(password);
    }

    public void clickLogInButton() {
        element(logInButton).click();
    }

    public String getInvalidPasswordWrapperText() {
        Helpers.waitFor(2, () -> !element(passwordErrorMessage).getText().equals(""),
                "invalid password message didn't displayed");

        return element(passwordErrorMessage).getText();
    }
}
