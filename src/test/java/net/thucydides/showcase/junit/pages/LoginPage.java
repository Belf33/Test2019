package net.thucydides.showcase.junit.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static net.thucydides.showcase.junit.utils.Strings.format;

@DefaultUrl("https://wallet.polygon.technology/login/")
public class LoginPage extends PageObject {
    @FindBy(xpath = "//div[contains(text(),'Login')]")
    WebElement loginHeader;

    public void selectWallet(String metamask) {
        System.out.println(String.format("//span[contains(text(),'%s')]", metamask));

        $(String.format("//span[contains(text(),'%s')]", metamask)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isSighUpPopupVisible() {
        return element(loginHeader).isCurrentlyVisible();
    }

}
