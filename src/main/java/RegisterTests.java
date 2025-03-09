import pageobject.*;
import helpers.RestApiRequests;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegisterTests extends BaseTests {

    @Test
    @Description("Test Case 1: Register User")
    public void register_new_account_should_successfully_create_and_delete_account() {
        HomePage homePage = new HomePage(browser);
        DeletedAccountPage deletedAccountPage = (((RegisterPage) homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInShortRegisterForm(personalData))
                .fillInLongRegisterForm(personalData))
                .clickCreatedAccount()
                .clickContinue(personalData.firstName)
                .headerComponent.goToDeletedAccount();

        Assertions.assertTrue(deletedAccountPage.ifAccountDeleted(),
                "Account did not deleted!");
    }

    @Test
    @Description("Test Case 5: Register User with existing email")
    public void register_new_account_with_already_existing_name_and_email_should_display_error() {

        RestApiRequests request = new RestApiRequests();
        request.createAccount();

        HomePage homePage = new HomePage(browser);
        BasePage loginPage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInShortRegisterForm(personalData);

        Assertions.assertTrue(((LoginPage) loginPage).ifDisplayRegisterError(),
                "Error did not display.");

        request.deleteAccount();
    }
}
