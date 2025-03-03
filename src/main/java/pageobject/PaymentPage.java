package pageobject;

import helpers.Browser;
import helpers.PaymentData;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    private final By nameOnCartInputLocator = By.cssSelector("[data-qa='name-on-card']");
    private final By cardNumberInputLocator = By.cssSelector("[data-qa='card-number']");
    private final By cvsInputLocator = By.cssSelector("[data-qa='cvc']");
    private final By expirationMonthInputLocator = By.cssSelector("[data-qa='expiry-month']");
    private final By expirationYearInputLocator = By.cssSelector("[data-qa='expiry-year']");
    private final By payAndConfirmOrderButtonLocator = By.cssSelector("#submit");
    private final By orderPlacedPageTitleLocator = By.cssSelector("[data-qa='order-placed']");

    public PaymentPage(Browser browser) {
        super(browser);
    }

    public PaymentPage fillInPaymentData(PaymentData paymentData) {
        browser.driver.findElement(nameOnCartInputLocator).sendKeys(paymentData.nameOnCard);
        browser.driver.findElement(cardNumberInputLocator).sendKeys(paymentData.cardNumber);
        browser.driver.findElement(cvsInputLocator).sendKeys(paymentData.cvc);
        browser.driver.findElement(expirationMonthInputLocator).sendKeys(paymentData.expirationMonth);
        browser.driver.findElement(expirationYearInputLocator).sendKeys(paymentData.expirationYear);
        return this;
    }

    public OrderPlacedPage clickPayAndConfirmOrder() {
        browser.driver.findElement(payAndConfirmOrderButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(orderPlacedPageTitleLocator));
        return new OrderPlacedPage(browser);
    }
}
