import pageobject.DeletedAccountPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import helpers.RestApiRequests;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTests {

    @Test
    @Description("Test Case 2: Login User with correct email and password")
    public void login_user_with_correct_email_and_password_should_successfully_login() {

        RestApiRequests request = new RestApiRequests();
        request.createAccount();

        HomePage homePage = new HomePage(browser);
        DeletedAccountPage deletedAccountPage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInLoginForm(personalData)
                .headerComponent.goToDeletedAccount();

        Assertions.assertTrue(deletedAccountPage.ifAccountDeleted(),
                "Account did not deleted!");

    }

    @Test
    @Description("Test Case 3: Login User with incorrect email and password")
    public void login_user_with_incorrect_email_and_password_should_not_successfully_login() {

        RestApiRequests request = new RestApiRequests();
        request.createAccount();

        HomePage homePage = new HomePage(browser);
        LoginPage loginPage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInIncorrectLoginForm(personalData);

        Assertions.assertEquals("Your email or password is incorrect!", loginPage.getLoginError(),
                "Error doesn't display");

        request.deleteAccount();
    }

    @Test
    @Description("Test Case 4: Logout User")
    public void logout_button_should_logout_user() {

        RestApiRequests request = new RestApiRequests();
        request.createAccount();

        HomePage homePage = new HomePage(browser);
        LoginPage loginPage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInLoginForm(personalData)
                .headerComponent.goToLogout();

        Assertions.assertEquals("Login to your account", loginPage.getLoginPageTitle(),
                "User didn't logout");

        request.deleteAccount();
    }
}
