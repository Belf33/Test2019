package net.thucydides.showcase.junit.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.junit.model.ValidUser;
import net.thucydides.showcase.junit.steps.HomeSteps;
import net.thucydides.showcase.junit.steps.ShoppingListSteps;
import net.thucydides.showcase.junit.steps.SignInSteps;
import net.thucydides.showcase.junit.utils.Helpers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SignInTests {

    @Managed
    WebDriver driver;

    @Steps
    HomeSteps homeSteps;

    @Steps
    SignInSteps signInSteps;

    @Steps
    ShoppingListSteps shoppingListSteps;

    ValidUser validUser = new ValidUser();

    @Test
    public void successDisplayingAuthPopupWhenOpenHomePage() {
        homeSteps.openHomePage();
        homeSteps.authPopupShouldBeDisplayed();
    }

    @Test
    public void successOpensEnterPasswordPopupWhenTypeValidEmail() {
        homeSteps.openHomePage();

        signInSteps.enterEmail(validUser.email);
        signInSteps.clickContinueButton();
        signInSteps.passwordPopupShouldBeOpened();
    }

    @Test
    public void failureLoginWithValidEmailAndInvalidPassword() {
        String invalidPassword = Helpers.getAlphanumericRandomString(10);

        homeSteps.openHomePage();

        signInSteps.enterEmail(validUser.email);
        signInSteps.clickContinueButton();
        signInSteps.enterPassword(invalidPassword);
        signInSteps.clickLogInButton();
        signInSteps.invalidPasswordMessageShouldBeDisplayed();
    }

    @Test
    public void successLoginWithValidNameAndPassword() {
        homeSteps.openHomePage();

        signInSteps.enterEmail(validUser.email);
        signInSteps.clickContinueButton();
        signInSteps.enterPassword(validUser.password);
        signInSteps.clickLogInButton();

        shoppingListSteps.userEmailNameShouldBeDisplayed(validUser.email);
    }
}
