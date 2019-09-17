package net.thucydides.showcase.junit.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.junit.pages.ItemPopup;
import net.thucydides.showcase.junit.pages.ShoppingListItemsListPage;
import net.thucydides.showcase.junit.pages.ShoppingListPage;
import org.junit.Assert;

public class ShoppingListSteps extends ScenarioSteps {

    ShoppingListPage shoppingListPage;
    ShoppingListItemsListPage shoppingListItemsListPage;
    ItemPopup itemPopup;

    @Step
    public void userEmailNameShouldBeDisplayed(String email) {
        Assert.assertEquals(email, shoppingListPage.getActiveUserAvatarName());
    }

    @Step
    public void clickAddItemInput() {
        shoppingListPage.clickAddItemInput();
    }

    @Step
    public String addItemFromPopularBlock() {
        return shoppingListPage.addRandomItemFromPopularBlock();
    }

    @Step
    public void openShoppingList() {
        shoppingListPage.clickShoppingList();
    }

    @Step
    public void addedItemShouldBePresentInTheList(String selectedItem) {
        Assert.assertTrue(shoppingListItemsListPage.isItemPresentInTheItemList(selectedItem));
    }

    @Step
    public void openSelectedItem(String selectedItem) {
        shoppingListItemsListPage.openItem(selectedItem);
    }

    @Step
    public void clickDeleteItemButton() {
        itemPopup.clickDeleteButton();
    }

    public void deletedItemShouldNotDisplayedInTheList(String selectedItem) {
        Assert.assertFalse(shoppingListItemsListPage.isItemPresentInTheItemList(selectedItem));
    }
}
