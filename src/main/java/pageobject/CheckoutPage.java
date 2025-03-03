package pageobject;

import helpers.Browser;
import helpers.PersonalData;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    private final By deliveryAddressFirstLineLocator = By.cssSelector("#address_delivery .address_firstname");
    private final By deliveryAddressSecondLineLocator = By.cssSelector("#address_delivery li:nth-child(4)");
    private final By deliveryAddressThirdLineLocator = By.cssSelector("#address_delivery .address_city");
    private final By deliveryAddressFourthLineLocator = By.cssSelector("#address_delivery .address_country_name");
    private final By deliveryAddressFifthLineLocator = By.cssSelector("#address_delivery .address_phone");
    private final By billingAddressFirstLineLocator = By.cssSelector("#address_invoice .address_firstname");
    private final By billingAddressSecondLineLocator = By.cssSelector("#address_invoice li:nth-child(4)");
    private final By billingAddressThirdLineLocator = By.cssSelector("#address_invoice .address_city");
    private final By billingAddressFourthLineLocator = By.cssSelector("#address_invoice .address_country_name");
    private final By billingAddressFifthLineLocator = By.cssSelector("#address_invoice .address_phone");
    private final By messageToOrderInputLocator = By.cssSelector("#ordermsg textarea");
    private final By placeOrderButtonLocator = By.cssSelector(".btn-default.check_out");
    private final By paymentPageTitleLocator = By.cssSelector("#cart_items");

    public final CartCheckerComponent cartCheckerComponent;

    public CheckoutPage(Browser browser) {
        super(browser);
        cartCheckerComponent = new CartCheckerComponent(browser);
    }

    public void verifyDeliveryAddress(PersonalData personalData) {
        String expectedFirstLine = personalData.title + ". " + personalData.firstName + " " + personalData.lastName;
        if ( !browser.driver.findElement(deliveryAddressFirstLineLocator).getText().equals(expectedFirstLine) ) {
            throw new RuntimeException("Delivery data are not correct: " + personalData.title + ", "
                    + personalData.firstName + " or " + personalData.lastName + " !");
        }

        String expectedSecondLine = personalData.address;
        if ( !browser.driver.findElement(deliveryAddressSecondLineLocator).getText().equals(expectedSecondLine) ) {
            throw new RuntimeException("Delivery data are not correct: " + personalData.address + " !");
        }

        String expectedThirdLine = personalData.city + " " + personalData.state + " " + personalData.zipCode;
        if ( !browser.driver.findElement(deliveryAddressThirdLineLocator).getText().equals(expectedThirdLine) ) {
            throw new RuntimeException("Delivery data are not correct: " + personalData.city + ", "
                    + personalData.state + " or " + personalData.zipCode + " !");
        }

        String expectedFourthLine = personalData.country;
        if ( !browser.driver.findElement(deliveryAddressFourthLineLocator).getText().equals(expectedFourthLine) ) {
            throw new RuntimeException("Delivery data are not correct: " + personalData.country + " !");
        }

        String expectedFifthLine = personalData.mobileNumber;
        if ( !browser.driver.findElement(deliveryAddressFifthLineLocator).getText().equals(expectedFifthLine) ) {
            throw new RuntimeException("Delivery data are not correct: " + personalData.mobileNumber + " !");
        }

    }

    public void verifyBillingAddress(PersonalData personalData) {
        if (!browser.driver.findElement(billingAddressFirstLineLocator)
                .getText().equals(personalData.title + ". " + personalData.firstName + " " + personalData.lastName)) {
            throw new RuntimeException("Billing data are not correct: " + personalData.title + ", "
                    + personalData.firstName + " or " + personalData.lastName + " !");
        }

        if (!browser.driver.findElement(billingAddressSecondLineLocator)
                .getText().equals(personalData.address)) {
            throw new RuntimeException("Billing data are not correct: " + personalData.address + " !");
        }

        if (!browser.driver.findElement(billingAddressThirdLineLocator)
                .getText().equals(personalData.city + " " + personalData.state + " " + personalData.zipCode)) {
            throw new RuntimeException("Billing data are not correct: " + personalData.city + ", "
                    + personalData.state + " or " + personalData.zipCode + " !");
        }

        if (!browser.driver.findElement(billingAddressFourthLineLocator)
                .getText().equals(personalData.country)) {
            throw new RuntimeException("Billing data are not correct: " + personalData.country + " !");
        }

        if (!browser.driver.findElement(billingAddressFifthLineLocator)
                .getText().equals(personalData.mobileNumber)) {
            throw new RuntimeException("Billing data are not correct: " + personalData.mobileNumber + " !");
        }

    }

    public CheckoutPage fillInMessage(String message) {
        browser.driver.findElement(messageToOrderInputLocator).sendKeys(message);
        return this;
    }

    public PaymentPage clickPlaceOrder() {
        browser.driver.findElement(placeOrderButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(paymentPageTitleLocator));
        return new PaymentPage(browser);
    }
}
