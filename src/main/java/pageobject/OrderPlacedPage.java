package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class OrderPlacedPage extends BasePage {

    private final By positiveMessageLocator = By.cssSelector("[data-qa='order-placed'] + p");

    public final HeaderComponent headerComponent;

    public OrderPlacedPage(Browser browser) {
        super(browser);
        headerComponent = new HeaderComponent(browser);
    }

    public boolean verifyPositiveMessage() {
        String message = "Congratulations! Your order has been confirmed!";
        return browser.driver.findElement(positiveMessageLocator).getText().equals(message);
    }
}
