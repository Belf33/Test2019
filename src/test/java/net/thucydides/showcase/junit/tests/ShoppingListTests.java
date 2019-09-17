package net.thucydides.showcase.junit.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.junit.model.ValidUser;
import net.thucydides.showcase.junit.steps.HomeSteps;
import net.thucydides.showcase.junit.steps.ShoppingListSteps;
import net.thucydides.showcase.junit.steps.SignInSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ShoppingListTests {

    @Managed
    WebDriver driver;

    @Steps
    HomeSteps homeSteps;

    @Steps
    SignInSteps signInSteps;

    @Steps
    ShoppingListSteps shoppingListSteps;

    ValidUser validUser = new ValidUser();

    //Необходимо иметь метод на бэке, что бы создавать чистого юзера или сносить состояние к дефолтному.
    // Иначе тесты будут зависимы от предыдущего состояния и будут нестабильными.
    // На данный момент они нестабильны.

    @Test
    public void successAddRandomItemFromPopularList() {
        String selectedItem;

        homeSteps.openHomePage();

        signInSteps.signInWith(validUser);

        shoppingListSteps.clickAddItemInput();
        selectedItem = shoppingListSteps.addItemFromPopularBlock();

        shoppingListSteps.openShoppingList();
        shoppingListSteps.addedItemShouldBePresentInTheList(selectedItem);

        // это кусок из следующего теста, но это костыль, тк нет метода для возврата всего к дефолтному состоянию
        shoppingListSteps.openSelectedItem(selectedItem);
        shoppingListSteps.clickDeleteItemButton();
        shoppingListSteps.deletedItemShouldNotDisplayedInTheList(selectedItem);
    }

    @Test
    public void successDeleteRandomItemFromPopularList() {
        String selectedItem;

        homeSteps.openHomePage();

        signInSteps.signInWith(validUser);

        shoppingListSteps.clickAddItemInput();
        selectedItem = shoppingListSteps.addItemFromPopularBlock();

        shoppingListSteps.openShoppingList();
        shoppingListSteps.openSelectedItem(selectedItem);
        shoppingListSteps.clickDeleteItemButton();
        shoppingListSteps.deletedItemShouldNotDisplayedInTheList(selectedItem);
    }
}
