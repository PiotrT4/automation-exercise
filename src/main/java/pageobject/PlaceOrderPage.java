package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class PlaceOrderPage extends BasePage {

    private final By downloadInvoiceButtonLocator = By.cssSelector("[href^='/download_invoice/']");

    public final HeaderComponent headerComponent;

    public PlaceOrderPage(Browser browser) {
        super(browser);
        headerComponent = new HeaderComponent(browser);
    }

    public PlaceOrderPage clickDownloadInvoice() {
        browser.driver.findElement(downloadInvoiceButtonLocator).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    public boolean isInvoiceExists(String downloadFilesDirectoryPath, String invoiceName) {
        File directory = new File(downloadFilesDirectoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().startsWith(invoiceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void deleteInvoice(String downloadFilesDirectoryPath, String invoiceName) {
        File file = new File(downloadFilesDirectoryPath + "\\" + invoiceName);
        if (file.exists() && file.delete()) {
            System.out.println(invoiceName + " successfully deleted");
        } else {
            System.out.println(invoiceName + " not successfully deleted");
        }
    }
}
