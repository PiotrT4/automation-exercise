package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    public final SubscriptionComponent subscriptionComponent;
    public final HeaderComponent headerComponent;
    public final ProductInteractionComponent productInteractionComponent;
    public final CategorySidebarComponent categorySidebarComponent;

    public HomePage(Browser browser) {
        super(browser);
        subscriptionComponent = new SubscriptionComponent(browser);
        headerComponent = new HeaderComponent(browser);
        productInteractionComponent = new ProductInteractionComponent(browser);
        categorySidebarComponent = new CategorySidebarComponent(browser);
    }

    public HomePage runBrowser() {
        browser.driver.get(browser.baseUrl);
        return this;
    }

    public boolean ifOnHomePage() {
        return (browser.baseUrl + "/").equals(browser.driver.getCurrentUrl());
    }

}
