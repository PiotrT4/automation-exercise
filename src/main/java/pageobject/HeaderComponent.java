package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class HeaderComponent extends BasePage {

    private final By loginButtonLocator = By.cssSelector("div.shop-menu a[href='/login']");
    private final By loginPageTitleLocator = By.cssSelector(".signup-form h2");
    private final By deleteAccountButtonLocator = By.cssSelector("div.shop-menu a[href='/delete_account']");
    private final By deletedAccountPageTitleLocator = By.cssSelector("h2[data-qa='account-deleted']");
    private final By logoutButtonLocator = By.cssSelector("div.shop-menu a[href='/logout']");
    private final By contactUsButtonLocator = By.cssSelector("div.shop-menu a[href='/contact_us']");
    private final By contactUsPageTitleLocator = By.cssSelector("div.contact-form h2");
    private final By testCasesButtonLocator = By.cssSelector("div.shop-menu a[href='/test_cases']");
    private final By testCasesPageTitleLocator = By.cssSelector("h2.title b");
    private final By productsButtonLocator = By.cssSelector("div.shop-menu a[href='/products']");
    private final By productsPageTitleLocator = By.cssSelector("div.features_items h2.title");
    private final By cartButtonLocator = By.cssSelector("div.shop-menu a[href='/view_cart']");
    private final By cartPageTitleLocator = By.cssSelector("div#cart_info");

    public HeaderComponent(Browser browser) {
        super(browser);
    }

    public LoginPage goToLogin() {
        browser.driver.findElement(loginButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(loginPageTitleLocator));
        return new LoginPage(browser);
    }

    public DeletedAccountPage goToDeletedAccount() {
        browser.wait.until(drive -> drive.findElement(deleteAccountButtonLocator));
        browser.driver.findElement(deleteAccountButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(deletedAccountPageTitleLocator));
        return new DeletedAccountPage(browser);
    }

    public LoginPage goToLogout() {
        browser.driver.findElement(logoutButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(loginPageTitleLocator));
        return new LoginPage(browser);
    }

    public ContactUsPage goToContactUs() {
        browser.driver.findElement(contactUsButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(contactUsPageTitleLocator));
        return new ContactUsPage(browser);
    }

    public void goToTestCases() {
        browser.driver.findElement(testCasesButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(testCasesPageTitleLocator));
        new TestCasesPage(browser);
    }

    public ProductsPage goToProducts() {
        browser.driver.findElement(productsButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(productsPageTitleLocator));
        return new ProductsPage(browser);
    }

    public CartPage goToCart() {
        browser.driver.findElement(cartButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(cartPageTitleLocator));
        return new CartPage(browser);
    }


}
