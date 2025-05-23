package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    public final WebDriver driver;
    public final String baseUrl;
    public final WebDriverWait wait;

    public Browser(WebDriver driver, ConfigurationReader configurationReader) {
        this.driver = driver;
        this.baseUrl = configurationReader.getBaseUrl();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(configurationReader.getWaitInSeconds()));
    }
}
