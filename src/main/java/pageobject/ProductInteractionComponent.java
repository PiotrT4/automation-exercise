package pageobject;

import helpers.Browser;
import helpers.ByHelper;
import helpers.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductInteractionComponent extends BasePage {

    private final By viewProductButtonByIdLocator = By.cssSelector(".features_items a[href='/product_details/%s']");
    private final By productDetailsTitleLocator = By.cssSelector("div[class='product-details']");
    private final By addToCartProductButtonByIdLocator = By.cssSelector(".features_items .productinfo  a[data-product-id='%s']");
    private final By cartModalBodyLocator = By.cssSelector("div#cartModal");
    private final By productPriceByIdLocator = By.cssSelector(".features_items img[src$='%s'] + h2");
    private final By selectAllProductsOnPageLocator = By.cssSelector("div[class='product-image-wrapper'] li");

    public ProductInteractionComponent(Browser browser) {
        super(browser);
    }
    public ProductDetailsPage clickViewById(String productId) {
        ByHelper byHelper = new ByHelper(viewProductButtonByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(productId);
        browser.driver.findElement(newLocator).click();
        browser.wait.until(drive -> drive.findElement(productDetailsTitleLocator));
        return new ProductDetailsPage(browser);
    }

    public ProductsPage clickAddToCartById(ProductData productData) {
        ByHelper byHelper = new ByHelper(addToCartProductButtonByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(productData.getId());

        updatePriceAndQuantity(productData);

        browser.driver.findElement(newLocator).click();
        browser.wait.until(drive -> drive.findElement(cartModalBodyLocator).isDisplayed());
        return new ProductsPage(browser);
    }

    private void updatePriceAndQuantity(ProductData productData) {
        ByHelper byHelper = new ByHelper(productPriceByIdLocator);
        By newLocator = byHelper.getNewLocatorWithProductId(productData.getId());

        int index = browser.driver.findElement(newLocator).getText().indexOf(" ");
        String newPrice = browser.driver.findElement(newLocator).getText().substring(index + 1);
        productData.setPrice(newPrice);

        if (productData.getQuantity() == null) {
            productData.setQuantity("1");
        } else {
            int quantityToInt = Integer.parseInt(productData.getQuantity());
            quantityToInt++;
            productData.setQuantity(String.valueOf(quantityToInt));
        }
    }

    public ProductDetailsPage clickViewOnRandomProduct() {
        List<WebElement> listOfViewProductButtons = browser.driver.findElements(selectAllProductsOnPageLocator);
        Random random = new Random();
        WebElement randomViewProductButton = listOfViewProductButtons
                .get(random.nextInt(listOfViewProductButtons.size()));
        randomViewProductButton.click();
        return new ProductDetailsPage(browser);
    }
}
