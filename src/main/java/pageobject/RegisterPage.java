package pageobject;

import helpers.Browser;
import helpers.PersonalData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends BasePage {

    private final By titlesLocator = By.cssSelector("[for^='id_gender']");
    private final By passwordInputLocator = By.cssSelector("input[data-qa='password']");
    private final By newsletterInputLocator = By.cssSelector("#uniform-newsletter input");
    private final By specialOffersInputLocator = By.cssSelector("input#optin");
    private final By firstNameInputLocator = By.cssSelector("input#first_name");
    private final By lastNameInputLocator = By.cssSelector("input#last_name");
    private final By addressInputLocator = By.cssSelector("input[data-qa='address']");
    private final By countrySelectorLocator = By.cssSelector("select#country");
    private final By countriesInputLocator = By.cssSelector("#country option");
    private final By stateInputLocator = By.cssSelector("input#state");
    private final By cityInputLocator = By.cssSelector("input#city");
    private final By zipCodeInputLocator = By.cssSelector("input#zipcode");
    private final By mobileNumberInputLocator = By.cssSelector("input#mobile_number");
    private final By createAccountButtonLocator = By.cssSelector("button[data-qa='create-account']");
    private final By createdAccountPageTitleLocator = By.cssSelector("h2[data-qa='account-created']");

    public RegisterPage(Browser browser) {
        super(browser);
    }

    public RegisterPage fillInLongRegisterForm(PersonalData personalData) {
        List<WebElement> titleList = browser.driver.findElements(titlesLocator);
        findWebElementByText(titleList, personalData.title).click();

        browser.driver.findElement(passwordInputLocator).sendKeys(personalData.password);
        if (personalData.newsletter) { browser.driver.findElement(newsletterInputLocator).click(); }
        if (personalData.specialOffers) { browser.driver.findElement(specialOffersInputLocator).click(); }
        browser.driver.findElement(firstNameInputLocator).sendKeys(personalData.firstName);
        browser.driver.findElement(lastNameInputLocator).sendKeys(personalData.lastName);
        browser.driver.findElement(addressInputLocator).sendKeys(personalData.address);
        browser.driver.findElement(countrySelectorLocator).click();

        List<WebElement> countryList = browser.driver.findElements(countriesInputLocator);
        findWebElementByText(countryList, personalData.country).click();

        browser.driver.findElement(stateInputLocator).sendKeys(personalData.state);
        browser.driver.findElement(cityInputLocator).sendKeys(personalData.city);
        browser.driver.findElement(zipCodeInputLocator).sendKeys(personalData.zipCode);
        browser.driver.findElement(mobileNumberInputLocator).sendKeys(personalData.mobileNumber);
        return this;
    }

    public CreatedAccountPage clickCreatedAccount() {
        browser.driver.findElement(createAccountButtonLocator).click();
        browser.wait.until(drive -> drive.findElement(createdAccountPageTitleLocator));
        return new CreatedAccountPage(browser);
    }

    public WebElement findWebElementByText(List<WebElement> listOfWebElements, String text){
        for (WebElement webElement : listOfWebElements) {
            if (webElement.getText().contains(text)) { return webElement; }
        }
        throw new RuntimeException(text + " from testData.properties did not find on singup website!");
    }
}
