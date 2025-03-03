package pageobject;

import helpers.Browser;
import helpers.PersonalData;
import org.openqa.selenium.By;

import java.io.File;

public class ContactUsPage extends BasePage {

    private final By nameInputLocator = By.cssSelector("input[data-qa='name']");
    private final By emailInputLocator = By.cssSelector("input[data-qa='email']");
    private final By subjectInputLocator = By.cssSelector("input[data-qa='subject']");
    private final By messageInputLocator = By.cssSelector("textarea[data-qa='message']");
    private final By uploadFileLocator = By.cssSelector("input[type='file']");
    private final By submitButtonLocator = By.cssSelector("input[data-qa='submit-button']");
    private final By successMessageLocator = By.cssSelector("div#success-subscribe");
    private final By homeButtonLocator = By.cssSelector("a.btn-success");

    private final File file = new File("src/main/java/helpers/ExampleFileToUpload.jpg");

    public ContactUsPage(Browser browser) {
        super(browser);
    }

    public ContactUsPage fillInContactForm(PersonalData personalData) {
        browser.driver.findElement(nameInputLocator).sendKeys(personalData.firstName + personalData.lastName);
        browser.driver.findElement(emailInputLocator).sendKeys(personalData.email);
        browser.driver.findElement(subjectInputLocator).sendKeys(personalData.subject);
        browser.driver.findElement(messageInputLocator).sendKeys(personalData.message);
        browser.driver.findElement(uploadFileLocator).sendKeys(file.getAbsolutePath());
        return this;
    }

    public ContactUsPage clickSubmit() {
        browser.driver.findElement(submitButtonLocator).click();
        browser.driver.switchTo().alert().accept();
        browser.wait.until(drive -> drive.findElement(successMessageLocator));
        return this;
    }

    public void clickHome() {
        browser.driver.findElement(homeButtonLocator).click();
        new HomePage(browser);
    }
}
