package helpers;

import org.openqa.selenium.By;

public class ByHelper {
    private final By oldLocator;

    public ByHelper(By oldLocator) {
        this.oldLocator = oldLocator;
    }

    public By getNewLocatorWithProductId(String productId) {
        String newCssSelector = oldLocator.toString().substring(
                oldLocator.toString().indexOf(" ")+1);

        String newLocator = String.format(newCssSelector, productId);
        return By.cssSelector(newLocator);
    }
}
