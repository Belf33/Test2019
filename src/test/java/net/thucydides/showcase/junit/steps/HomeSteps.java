package net.thucydides.showcase.junit.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.junit.pages.HomePage;
import net.thucydides.showcase.junit.pages.AuthenticationPopup;
import net.thucydides.showcase.junit.pages.WelcomePopup;

import static org.junit.Assert.assertTrue;

public class HomeSteps extends ScenarioSteps {

    HomePage homePage;
    AuthenticationPopup authenticationPopup;
    WelcomePopup welcomePopup;

    @Step
    public void openHomePage() {
        homePage.open();
        skipWelcomePopup();
    }

    private void skipWelcomePopup() {
        if(welcomePopup.isWelcomePopupVisible())
            welcomePopup.clickSkipLink();
    }

    @Step
    public void authPopupShouldBeDisplayed() {
        assertTrue("Auth popup is not present on the page!", authenticationPopup.isSighUpPopupVisible());
    }
}
