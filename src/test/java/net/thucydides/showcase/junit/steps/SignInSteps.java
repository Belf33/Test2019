package net.thucydides.showcase.junit.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.junit.model.ValidUser;
import net.thucydides.showcase.junit.pages.AuthenticationPopup;
import net.thucydides.showcase.junit.pages.PasswordPopup;
import net.thucydides.showcase.junit.pages.ShoppingListPage;
import net.thucydides.showcase.junit.utils.Helpers;
import net.thucydides.showcase.junit.utils.Strings;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class SignInSteps extends ScenarioSteps {

    AuthenticationPopup authenticationPopup;
    PasswordPopup passwordPopup;
    ShoppingListPage shoppingListPage;

    @Step
    public void enterEmail(String email) {
        authenticationPopup.enterEmail(email);
    }

    @Step
    public void invalidEmailMessageShouldBeDisplayed() {
        assertEquals(Strings.get("sign.in.popup.invalid.email.error.text"),
                authenticationPopup.getInvalidEmailWrapperText());
    }

    @Step
    public void clickContinueButton() {
        authenticationPopup.clickContinueButton();
    }

    @Step
    public void passwordPopupShouldBeOpened() {
        assertEquals(Strings.get("password.popup.header.text"), passwordPopup.getPageTitle());
    }

    @Step
    public void enterPassword(String password) {
        passwordPopup.enterPassword(password);
    }

    @Step
    public void clickLogInButton() {
        passwordPopup.clickLogInButton();
    }

    @Step
    public void invalidPasswordMessageShouldBeDisplayed() {
        assertEquals(Strings.get("sign.in.popup.invalid.password.error.text"),
                passwordPopup.getInvalidPasswordWrapperText());
    }

    @StepGroup
    public void signInWith(ValidUser validUser) {
        enterEmail(validUser.email);
        clickContinueButton();
        enterPassword(validUser.password);
        clickLogInButton();

        Helpers.waitFor(2, () -> shoppingListPage.isPageLoad(), "Page is not finished loading.");
    }
}
