import org.testng.Assert;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pageobject.BasePage;
import pageobject.HomePage;
import pageobject.SubscriptionComponent;

public class SubscriptionTests extends BaseTests {

    @Test
    @Description("Test Case 10: Verify Subscription in home page")
    public void add_email_to_newsletter_on_homepage_should_successfully_subscribed() {

        HomePage homePage = new HomePage(browser);
        BasePage basePage = homePage
                .runBrowser()
                .subscriptionComponent.fillInEmail(personalData);

        SubscriptionComponent subscriptionComponent = (SubscriptionComponent) basePage;

        subscriptionComponent.clickSubmit();

        Assert.assertTrue(subscriptionComponent.isPositiveMessage(),
                "Message about added email to subscription is not displayed!");
    }

    @Test
    @Description("Test Case 11: Verify Subscription in Cart page")
    public void add_email_to_newsletter_on_cartpage_should_successfully_subscribed() {

        HomePage homePage = new HomePage(browser);
        BasePage basePage = homePage
                .runBrowser()
                .headerComponent.goToCart()
                .subscriptionComponent.fillInEmail(personalData);

        SubscriptionComponent subscriptionComponent = (SubscriptionComponent) basePage;

        subscriptionComponent.clickSubmit();

        Assert.assertTrue(subscriptionComponent.isPositiveMessage(),
                "Message about added email to subscription is not displayed!");
    }
}
