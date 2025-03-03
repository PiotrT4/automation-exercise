package pageobject;

import helpers.Browser;
import helpers.PersonalData;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By registerNameInputLocator = By.cssSelector("input[data-qa='signup-name']");
    private final By registerEmailInputLocator = By.cssSelector("input[data-qa='signup-email']");
    private final By registerButtonLocator = By.cssSelector("button[data-qa='signup-button']");
    private final By loginPageTitleLocator = By.cssSelector("div.login-form>h2");
    private final By loginEmailInputLocator = By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordInputLocator = By.cssSelector("input[data-qa='login-password']");
    private final By loginButtonLocator = By.cssSelector("button[data-qa='login-button']");
    private final By loginErrorMessageLocator = By.cssSelector("input[data-qa='login-password']+*");
    private final By registerErrorMessageLocator = By.cssSelector("input[name='form_type']+*");
    private final By loggedAsLocator = By.cssSelector(".shop-menu li:last-child a");

    public LoginPage(Browser browser) {
        super(browser);
    }

    public BasePage fillInShortRegisterForm(PersonalData personalData) {
        browser.driver.findElement(registerNameInputLocator).sendKeys(personalData.firstName);
        browser.driver.findElement(registerEmailInputLocator).sendKeys(personalData.email);
        browser.driver.findElement(registerButtonLocator).click();

        if (ifDisplayRegisterError()) {
           return new LoginPage(browser);
        } else {
            browser.wait.until(drive -> drive.findElement(loginPageTitleLocator));
            return new RegisterPage(browser);
        }
    }

    public HomePage fillInLoginForm(PersonalData personalData) {
        browser.driver.findElement(loginEmailInputLocator).sendKeys(personalData.email);
        browser.driver.findElement(loginPasswordInputLocator).sendKeys(personalData.password);
        browser.driver.findElement(loginButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(loggedAsLocator).getText()
                .equals("Logged in as " + personalData.firstName));
        return new HomePage(browser);
    }

    public LoginPage fillInIncorrectLoginForm(PersonalData personalData) {
        browser.driver.findElement(loginEmailInputLocator).sendKeys(personalData.email);
        browser.driver.findElement(loginPasswordInputLocator).sendKeys(personalData.incorrectPassword);
        browser.driver.findElement(loginButtonLocator).click();
        return this;
    }

    public String getLoginError() {
        return browser.driver.findElement(loginErrorMessageLocator).getText();
    }

    public String getLoginPageTitle() {
        return browser.driver.findElement(loginPageTitleLocator).getText();
    }

    public boolean ifDisplayRegisterError() {
        final String errorDescription = "Email Address already exist!";
        return browser.driver.findElement(registerErrorMessageLocator).getText().equals(errorDescription);
    }
}
