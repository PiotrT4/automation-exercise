package pageobject;

import helpers.Browser;
import helpers.ByHelper;
import helpers.ProductData;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By recommendedProductAddToCartButtonByIdLocator = By.cssSelector(
            "#recommended-item-carousel [data-product-id='%s']");
    private final By cartModalLocator = By.cssSelector("div#cartModal");

    public final SubscriptionComponent subscriptionComponent;
    public final HeaderComponent headerComponent;
    public final ProductInteractionComponent productInteractionComponent;
    public final CategorySidebarComponent categorySidebarComponent;
    public final CartModalComponent cartModalComponent;
    public final ScrollComponent scrollComponent;

    public HomePage(Browser browser) {
        super(browser);
        subscriptionComponent = new SubscriptionComponent(browser);
        headerComponent = new HeaderComponent(browser);
        productInteractionComponent = new ProductInteractionComponent(browser);
        categorySidebarComponent = new CategorySidebarComponent(browser);
        cartModalComponent = new CartModalComponent(browser);
        scrollComponent = new ScrollComponent(browser);
    }

    public HomePage runBrowser() {
        browser.driver.get(browser.baseUrl);
        return this;
    }

    public boolean ifOnHomePage() {
        return (browser.baseUrl + "/").equals(browser.driver.getCurrentUrl());
    }

    public HomePage addToCartRecommendedProduct(ProductData productData1) {
        ByHelper oldLocator = new ByHelper(recommendedProductAddToCartButtonByIdLocator);
        By newLocator = oldLocator.getNewLocatorWithProductId(productData1.getId());
        browser.wait.until(driver -> driver.findElement(newLocator).isDisplayed());
        browser.driver.findElement(newLocator).click();
        browser.wait.until(drive -> drive.findElement(cartModalLocator).isDisplayed());
        return this;
    }
}
