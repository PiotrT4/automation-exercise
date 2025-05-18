import org.testng.Assert;
import pageobject.HomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTests {

    @Test
    @Description("Test Case 6: Contact Us Form")
    public void fill_in_contact_form_should_successfully_send_it() {

        HomePage homePage = new HomePage(browser);
        homePage.runBrowser()
                .headerComponent.goToContactUs()
                .fillInContactForm(personalData)
                .clickSubmit()
                .clickHome();

        Assert.assertTrue(homePage.ifOnHomePage(), "You are not on home page!");
    }
}
