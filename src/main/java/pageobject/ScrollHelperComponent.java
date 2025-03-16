package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ScrollHelperComponent extends BasePage {

    private final By subscriptionTextLocator = By.cssSelector(".single-widget h2");
    private final By scrollBackToTopButtonLocator = By.cssSelector("#scrollUp");
    private final By logoLocator = By.cssSelector(".logo.pull-left");

    public ScrollHelperComponent(Browser browser) {
        super(browser);
    }

    public void scrollDownToBottomOfPage() {
        Actions actions = new Actions(browser.driver);
        actions.moveToElement(browser.driver.findElement(subscriptionTextLocator)).perform();
    }

    public void click() {
        browser.driver.findElement(scrollBackToTopButtonLocator).click();
    }

    public boolean isLogoVisible() {
        return browser.driver.findElement(logoLocator).isDisplayed();
    }
}
