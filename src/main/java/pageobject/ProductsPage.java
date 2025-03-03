package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By searchProductInputLocator = By.cssSelector("input#search_product");
    private final By searchProductButtonLocator = By.cssSelector("button#submit_search");
    private final By searchProductResultLocator = By.cssSelector("div.features_items");
    private final By selectAllProductsOnPageLocator = By.cssSelector("div.product-image-wrapper");

    public final CartModalComponent cartModalComponent;
    public final ProductInteractionComponent productInteractionComponent;
    public final CategorySidebarComponent categorySidebarComponent;
    public final BrandsSidebarComponent brandsSidebarComponent;

    public ProductsPage(Browser browser) {
        super(browser);
        cartModalComponent = new CartModalComponent(browser);
        productInteractionComponent = new ProductInteractionComponent(browser);
        categorySidebarComponent = new CategorySidebarComponent(browser);
        brandsSidebarComponent = new BrandsSidebarComponent(browser);
    }

    public ProductsPage searchProduct(String searchProduct) {
        browser.driver.findElement(searchProductInputLocator).sendKeys(searchProduct);
        browser.driver.findElement(searchProductButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(searchProductResultLocator));
        return this;
    }

    public boolean isAllProductsOnListVisible() {
        List<WebElement> productsList = browser.driver.findElements(selectAllProductsOnPageLocator);

        if(productsList.isEmpty()) return false;

        for (WebElement product : productsList){
            if(!product.isDisplayed()) return false;
        }

        return true;
    }
}
