package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class DeletedAccountPage extends BasePage {

    private final By deletedAccountTitleLocator = By.cssSelector("h2[data-qa='account-deleted']");
    private final By continueButtonLocator = By.cssSelector("a[data-qa='continue-button']");

    public DeletedAccountPage(Browser browser) {
        super(browser);
    }

    public boolean ifAccountDeleted() {
        return browser.driver.findElement(deletedAccountTitleLocator).getText().equals("ACCOUNT DELETED!");
    }

    public void clickContinue() {
        browser.driver.findElement(continueButtonLocator).click();
        new HomePage(browser);
    }
}
