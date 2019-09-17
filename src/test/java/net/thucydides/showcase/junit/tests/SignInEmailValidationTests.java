package net.thucydides.showcase.junit.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.showcase.junit.steps.HomeSteps;
import net.thucydides.showcase.junit.steps.SignInSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "test-data/invalid-emails.csv")
public class SignInEmailValidationTests {
    @Managed
    WebDriver driver;

    @Steps
    SignInSteps signInSteps;

    @Steps
    HomeSteps homeSteps;

    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    @Test
    public void failureSignInWithInvalidEmailOnSignInPage() {
        homeSteps.openHomePage();

        signInSteps.enterEmail(email);
        signInSteps.clickContinueButton();
        signInSteps.invalidEmailMessageShouldBeDisplayed();
    }
}
