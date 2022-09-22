package net.thucydides.showcase.junit.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.junit.model.ValidUser;
import net.thucydides.showcase.junit.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SignInTests {

    @Managed
    WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    ValidUser validUser = new ValidUser();

    @Before
    public void before() {

    }

    @Test
    public void successOpenMetamaskSingInPopup() {
        loginSteps.openLoginPage();
        loginSteps.authPopupShouldBeDisplayed();
        loginSteps.selectWallet("MetaMask");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
