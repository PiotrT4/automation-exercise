package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class CreatedAccountPage extends BasePage {

    private final By continueButtonLocator = By.cssSelector("a[data-qa='continue-button']");
    private final By loggedAsLocator = By.cssSelector(".shop-menu li:last-child a");

    public CreatedAccountPage(Browser browser) {
        super(browser);
    }

    public HomePage clickContinue(String firstName) {
        browser.driver.findElement(continueButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(loggedAsLocator).getText().equals("Logged in as " + firstName));
        return new HomePage(browser);
    }
}
