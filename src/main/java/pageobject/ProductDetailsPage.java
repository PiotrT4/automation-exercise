package pageobject;

import helpers.Browser;
import helpers.PersonalData;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {

    private final By productNameLocator = By.cssSelector("div.product-information h2");
    private final By categoryLocator = By.cssSelector("div.product-information p:first-of-type");
    private final By availabilityLocator = By.cssSelector("div.product-information p:nth-of-type(2)");
    private final By conditionLocator = By.cssSelector("div.product-information p:nth-of-type(3)");
    private final By brandLocator = By.cssSelector("div.product-information p:nth-of-type(4)");
    private final By quantityInputLocator = By.cssSelector("#quantity");
    private final By addToCartButtonLocator = By.cssSelector(".cart");
    private final By cartModalLocator = By.cssSelector("div#cartModal");
    private final By nameInputLocator = By.cssSelector("#name");
    private final By emailInputLocator = By.cssSelector("#email");
    private final By reviewInputLocator = By.cssSelector("#review");
    private final By reviewButtonLocator = By.cssSelector("#button-review");
    private final By reviewSuccessMessageLocator = By.cssSelector("#review-section .alert-success");

    public final CartModalComponent cartModalComponent;

    public ProductDetailsPage(Browser browser) {
        super(browser);
        cartModalComponent = new CartModalComponent(browser);
    }

    public boolean isProductNameVisible() {
        return browser.driver.findElement(productNameLocator).isDisplayed();
    }

    public boolean isCategoryVisible() {
        return browser.driver.findElement(categoryLocator).isDisplayed();
    }

    public boolean isAvailabilityVisible() {
        return browser.driver.findElement(availabilityLocator).isDisplayed();
    }

    public boolean isConditionVisible() {
        return browser.driver.findElement(conditionLocator).isDisplayed();
    }

    public boolean isBrandVisible() {
        return browser.driver.findElement(brandLocator).isDisplayed();
    }

    public ProductDetailsPage typeQuantity(int newQuantity) {
        browser.driver.findElement(quantityInputLocator).clear();
        browser.driver.findElement(quantityInputLocator).sendKeys(String.valueOf(newQuantity));
        return this;
    }

    public ProductDetailsPage clickAddToCart() {
        browser.driver.findElement(addToCartButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(cartModalLocator).isDisplayed());
        return this;
    }

    public ProductDetailsPage fillInReviewForm(PersonalData personalData) {
        browser.driver.findElement(nameInputLocator).sendKeys(
                personalData.firstName + " " + personalData.lastName);
        browser.driver.findElement(emailInputLocator).sendKeys(personalData.email);
        browser.driver.findElement(reviewInputLocator).sendKeys(personalData.message);
        return this;
    }

    public ProductDetailsPage clickSubmit() {
        browser.driver.findElement(reviewButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(reviewSuccessMessageLocator).isDisplayed());
        return this;
    }

    public boolean ifReviewSucessMessageDisplyed() {
        return browser.driver.findElement(reviewSuccessMessageLocator).isDisplayed();
    }
}
