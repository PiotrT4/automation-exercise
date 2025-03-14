import dev.failsafe.internal.util.Assert;
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
        BasePage basePage = ((SubscriptionComponent) homePage
                .runBrowser()
                .subscriptionComponent.fillInEmail(personalData))
                .clickSubmit();

        Assert.isTrue(((SubscriptionComponent)basePage).isPositiveMessage(),
                "Message about added email to subscription is not displayed!");
    }

    @Test
    @Description("Test Case 11: Verify Subscription in Cart page")
    public void add_email_to_newsletter_on_cartpage_should_successfully_subscribed() {

        HomePage homePage = new HomePage(browser);
        BasePage basePage = ((SubscriptionComponent)homePage
                .runBrowser()
                .headerComponent.goToCart()
                .subscriptionComponent.fillInEmail(personalData))
                .clickSubmit();

        Assert.isTrue(((SubscriptionComponent)basePage).isPositiveMessage(),
                "Message about added email to subscription is not displayed!");
    }
}
