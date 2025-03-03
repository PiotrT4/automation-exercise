package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class BrandsSidebarComponent extends BasePage {


    private final By poloButtonLocator = By.cssSelector(".brands-name a[href$='/Polo']");
    private final By breadcrumbsLocator = By.cssSelector(".breadcrumbs .active");
    private final By hmButtonLocator = By.cssSelector(".brands-name a[href$='/H&M']");

    public BrandsSidebarComponent(Browser browser) {
        super(browser);
    }

    public BrandProductsPage clickPoloBrand() {
        browser.driver.findElement(poloButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(breadcrumbsLocator).getText().equals("Polo"));
        return new BrandProductsPage(browser);
    }

    public BrandProductsPage clickHMBrand() {
        browser.driver.findElement(hmButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(breadcrumbsLocator).getText().equals("H&M"));
        return new BrandProductsPage(browser);
    }

}
