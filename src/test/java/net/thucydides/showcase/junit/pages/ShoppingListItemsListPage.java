package net.thucydides.showcase.junit.pages;

import net.thucydides.core.pages.PageObject;

public class ShoppingListItemsListPage extends PageObject {

    String addedItem = "//div[. = '%s']";

    public boolean isItemPresentInTheItemList(String selectedItem) {
        return element(String.format(addedItem, selectedItem)).isCurrentlyVisible();
    }

    public void openItem(String item) {
        element(String.format(addedItem, item)).click();
    }
}
