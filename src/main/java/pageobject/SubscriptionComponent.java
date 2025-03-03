package pageobject;

import helpers.Browser;
import helpers.PersonalData;
import org.openqa.selenium.By;

public class SubscriptionComponent extends BasePage {

    private final By subscriptionEmailInputLocator = By.cssSelector("input#susbscribe_email");
    private final By subscriptionEmailButtonLocator = By.cssSelector("button#subscribe");
    private final By subscriptionEmailMessageLocator = By.cssSelector("div#success-subscribe");

    public SubscriptionComponent(Browser browser) {
        super(browser);
    }

    public BasePage fillInEmail(PersonalData personalData) {
        browser.driver.findElement(subscriptionEmailInputLocator).sendKeys(personalData.email);
        return this;
    }

    public BasePage clickSubmit() {
        browser.driver.findElement(subscriptionEmailButtonLocator).click();
        return this;
    }

    public boolean isPositiveMessage() {
        return browser.driver.findElement(subscriptionEmailMessageLocator).isDisplayed();
    }
}
