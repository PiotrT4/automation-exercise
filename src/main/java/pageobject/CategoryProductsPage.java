package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class CategoryProductsPage extends BasePage {

    public final CategorySidebarComponent categorySidebarComponent;
    private final By categoryProductsTitleLocator = By.cssSelector(".title");

    public CategoryProductsPage(Browser browser) {
        super(browser);
        categorySidebarComponent = new CategorySidebarComponent(browser);
    }

    public boolean isMenTshirtsCategoryTitleDisplayed() {
        return browser.driver.findElement(categoryProductsTitleLocator).getText().equals("MEN - TSHIRTS PRODUCTS");
    }
}
