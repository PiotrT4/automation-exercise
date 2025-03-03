package pageobject;

import helpers.Browser;
import helpers.ByHelper;
import helpers.ProductData;
import org.openqa.selenium.By;

public class CartCheckerComponent extends BasePage {

    private final By productByIdLocator = By.cssSelector("#product-%s");
    private final By productPriceByIdLocator = By.cssSelector("#product-%s .cart_price");
    private final By productQuantityByIdLocator = By.cssSelector("#product-%s .cart_quantity .disabled");
    private final By productTotalPriceByIdLocator = By.cssSelector("#product-%s .cart_total_price");
    private final By productsQuantityLocator = By.cssSelector(".cart_quantity");

    public CartCheckerComponent(Browser browser) {
        super(browser);
    }

    public boolean isInCartById(String productId) {
        ByHelper byHelper = new ByHelper(productByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(productId);
        try {
            browser.driver.findElement(newLocator).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyPriceById(ProductData productData) {
        ByHelper byHelper = new ByHelper(productPriceByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(productData.getId());
        return browser.driver.findElement(newLocator).getText().equals("Rs. " + productData.getPrice());
    }

    public boolean verifyQuantityById(ProductData productData) {
        ByHelper byHelper = new ByHelper(productQuantityByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(productData.getId());
        return browser.driver.findElement(newLocator).getText().equals(productData.getQuantity());
    }

    public boolean verifyTotalPriceById(ProductData productData) {
        ByHelper byHelper = new ByHelper(productTotalPriceByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(productData.getId());
        return browser.driver.findElement(newLocator).getText().equals("Rs. " + productData.getTotalPrice());
    }

    public boolean verifyQuantityByQuantity(int quantity) {
        return browser.driver.findElement(productsQuantityLocator).getText().equals(String.valueOf(quantity));
    }

}
