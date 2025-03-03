package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BrowserFactory {

    public Browser createInstance(ConfigurationReader configurationReader) throws NoSuchBrowserExpetion {

        WebDriver driver = createDriverInstance(configurationReader);
        return new Browser(driver, configurationReader);
    }

    private WebDriver createDriverInstance(ConfigurationReader configurationReader) throws NoSuchBrowserExpetion {

        switch (configurationReader.getBrowser()) {
            case "chrome" -> {
                return createChromeInstance(configurationReader);
            }
            case "firefox" -> {
                return createFirefoxInstance(configurationReader);
            }
            case "edge" -> {
                return createEdgeInstance(configurationReader);
            }
            default -> throw new NoSuchBrowserExpetion(configurationReader.getBrowser());
        }
    }

    private WebDriver createChromeInstance(ConfigurationReader configurationReader) {

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(configurationReader.getUBlockChromePath()));
        options.addArguments("--disable-search-engine-choice-screen");

        if (configurationReader.isHeadless()) {
            return new ChromeDriver(options.addArguments("--headless"));
        } else {
            return new ChromeDriver(options);
        }
    }

    private WebDriver createFirefoxInstance(ConfigurationReader configurationReader) {

        FirefoxOptions options = new FirefoxOptions();
        FirefoxDriver driver;

        if (configurationReader.isHeadless()) {
            driver = new FirefoxDriver(options.addArguments("--headless"));

        } else {
            driver = new FirefoxDriver();
        }

        Path uBlockFirefoxPath = Paths.get(configurationReader.getUBlockFirefoxPath());
        driver.installExtension(uBlockFirefoxPath);

        return driver;
    }

    private WebDriver createEdgeInstance(ConfigurationReader configuration) {

        EdgeOptions options = new EdgeOptions();
        options.addExtensions(new File(configuration.getUBlockEdgePath()));

        if (configuration.isHeadless()) {
            return new EdgeDriver(options.addArguments("--headless"));
        } else {
            return new EdgeDriver(options);
        }
    }
}
