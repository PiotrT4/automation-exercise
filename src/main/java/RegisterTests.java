import org.testng.Assert;
import pageobject.*;
import helpers.RestApiRequests;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTests {

    @Test
    @Description("Test Case 1: Register User")
    public void register_new_account_should_successfully_create_and_delete_account() {
        RestApiRequests restApiRequests = new RestApiRequests();
        restApiRequests.deleteAccount();

        HomePage homePage = new HomePage(browser);

        BasePage basePage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInShortRegisterForm(personalData);

        RegisterPage registerPage = (RegisterPage) basePage;

        DeletedAccountPage deletedAccountPage = registerPage
                .fillInLongRegisterForm(personalData)
                .clickCreatedAccount()
                .clickContinue(personalData.firstName)
                .headerComponent.goToDeletedAccount();

        Assert.assertTrue(deletedAccountPage.ifAccountDeleted(),
                "Account did not deleted!");
    }

    @Test
    @Description("Test Case 5: Register User with existing email")
    public void register_new_account_with_already_existing_name_and_email_should_display_error() {

        RestApiRequests request = new RestApiRequests();
        request.createAccount();

        HomePage homePage = new HomePage(browser);
        BasePage basePage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInShortRegisterForm(personalData);

        LoginPage loginPage = (LoginPage) basePage;

        Assert.assertTrue(loginPage.ifDisplayRegisterError(),
                "Error did not display.");

        request.deleteAccount();
    }
}
