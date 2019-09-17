package net.thucydides.showcase.junit.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPopup extends PageObject {

    @FindBy(xpath = "//button[@type='submit']/../div/div/div/button")
    WebElement deleteButton;

    public void clickDeleteButton() {
        element(deleteButton).click();
    }
}
