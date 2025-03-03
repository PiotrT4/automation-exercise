package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class CartModalComponent extends BasePage {

    private final By continueShoppingButtonLocator = By.cssSelector("button[data-dismiss='modal']");
    private final By viewCartButtonLocator = By.cssSelector("div#cartModal a[href='/view_cart']");
    private final By cartPageTitleLocator = By.cssSelector("tr.cart_menu");

    public CartModalComponent(Browser browser) {
        super(browser);
    }

    public ProductsPage clickContinueShopping() {
        browser.driver.findElement(continueShoppingButtonLocator).click();
        return new ProductsPage(browser);
    }

    public CartPage clickViewCart() {
        browser.driver.findElement(viewCartButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(cartPageTitleLocator));
        return new CartPage(browser);
    }

}
