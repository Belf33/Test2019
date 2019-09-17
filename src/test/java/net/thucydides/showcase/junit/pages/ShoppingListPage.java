package net.thucydides.showcase.junit.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.junit.utils.Helpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ShoppingListPage extends PageObject {

    @FindBy(xpath = "//button[@data-testid='avatar-button']")
    WebElement userAvatarName;

    @FindBy(xpath = "//input[@data-testid='desktop-add-item-autocomplete']")
    WebElement addItemInput;

    @FindBy(xpath = "//div[@data-testid='desktop-add-item-autocomplete']/div/div/div/div/div[2]")
    List<WebElement> itemList;

    @FindBy(xpath = "//div[@data-testid='shopping-lists-list-name']")
    WebElement shoppingListLink;

    public String getActiveUserAvatarName() {
        return element(userAvatarName).getText();
    }

    public void clickAddItemInput() {
        element(addItemInput).click();
    }

    public String addRandomItemFromPopularBlock() {
        WebElement currentWebElement = itemList.get(Helpers.getRandomNumberInRange(itemList.size()));

        String selectedItemName = element(currentWebElement).getText();

        element(currentWebElement).click();

        return selectedItemName;
    }

    public void clickShoppingList() {
        element(shoppingListLink).click();
    }

    public boolean isPageLoad() {
        return element(userAvatarName).isCurrentlyVisible();
    }
}
