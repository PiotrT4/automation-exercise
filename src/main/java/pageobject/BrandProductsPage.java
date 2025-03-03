package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrandProductsPage extends BasePage {

    private final By productsLocator = By.cssSelector(".features_items .col-sm-4");

    public final BrandsSidebarComponent brandsSidebarComponent;

    public BrandProductsPage(Browser browser) {
        super(browser);
        brandsSidebarComponent = new BrandsSidebarComponent(browser);
    }
    public boolean ifBrandProductsDisplayed() {
        List<WebElement> listOfProducts = browser.driver.findElements(productsLocator);

        if (listOfProducts.isEmpty()) { return false; }

        for(WebElement product : listOfProducts) {
            if(!product.isDisplayed()) return false;
        }

        return true;
    }
}
