package net.thucydides.showcase.junit.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.junit.pages.LoginPage;
import net.thucydides.showcase.junit.pages.AuthenticationPopup;

import static org.junit.Assert.assertTrue;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;
    AuthenticationPopup authenticationPopup;

    @Step
    public void openLoginPage() {
        loginPage.open();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step
    public void authPopupShouldBeDisplayed() {
        assertTrue("Auth popup is not present on the page!", authenticationPopup.isSighUpPopupVisible());
    }

    @Step
    public void selectWallet(String metamask) {
        loginPage.selectWallet(metamask);
    }
}
