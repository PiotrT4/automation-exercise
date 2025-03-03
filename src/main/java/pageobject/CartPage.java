package pageobject;

import helpers.Browser;
import helpers.ByHelper;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By checkoutButtonLocator = By.cssSelector(".btn-default.check_out");
    private final By modalCheckoutBodyLocator = By.cssSelector(".modal-content");
    private final By modalCheckoutLoginButtonLocator = By.cssSelector(".modal-body a[href='/login']");
    private final By loginPageTitleLocator = By.cssSelector(".signup-form h2");
    private final By deleteProductByIdLocator = By.cssSelector(".cart_quantity_delete[data-product-id='%s']");

    public final SubscriptionComponent subscriptionComponent;
    public final CartCheckerComponent cartCheckerComponent;
    public final HeaderComponent headerComponent;

    public CartPage(Browser browser) {
        super(browser);
        subscriptionComponent = new SubscriptionComponent(browser);
        cartCheckerComponent = new CartCheckerComponent(browser);
        headerComponent = new HeaderComponent(browser);
    }

    public BasePage clickProceedToCheckout() {
        browser.driver.findElement(checkoutButtonLocator).click();

        try {
            browser.driver.findElement(modalCheckoutBodyLocator);
            return new CartPage(browser);

        } catch (org.openqa.selenium.NoSuchElementException e) {
            browser.wait.until(driver -> driver.findElement(By.cssSelector("#cart_items")));
            return new CheckoutPage(browser);
        }
    }

    public LoginPage clickRegisterOrLogin() {
        browser.driver.findElement(modalCheckoutLoginButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(loginPageTitleLocator));
        return new LoginPage(browser);
    }
    public CartPage removeProductById(String id) {
        ByHelper byHelper = new ByHelper(deleteProductByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(id);
        browser.driver.findElement(newLocator).click();
        browser.wait.until(driver -> driver.findElements(newLocator).isEmpty());
        return this;
    }

}
