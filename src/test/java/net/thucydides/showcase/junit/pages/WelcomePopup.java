package net.thucydides.showcase.junit.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePopup extends PageObject {

    @FindBy(xpath = "//div[. = 'Welcome to Whisk']")
    WebElement titleWrapper;

    @FindBy(xpath = "//a[@data-testid='onboarding-skip']")
    WebElement skipLink;

    public boolean isWelcomePopupVisible() {
        return element(titleWrapper).isCurrentlyVisible();
    }

    public void clickSkipLink() {
        element(skipLink).click();
    }
}
