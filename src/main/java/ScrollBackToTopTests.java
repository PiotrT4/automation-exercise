import dev.failsafe.internal.util.Assert;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pageobject.HomePage;

public class ScrollBackToTopTests extends BaseTests {

    @Test
    @Description("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void scroll_down_and_click_ScrollBackToTopButton_should_scroll_to_top_of_website() {
        HomePage homePage = new HomePage(browser);
        homePage.runBrowser();
        homePage.scrollComponent.scrollDownToBottomOfPage();
        homePage.scrollComponent.click();

        Assert.isTrue(homePage.scrollComponent.isLogoVisible(),
                "Logo in not visible!");
    }
}
