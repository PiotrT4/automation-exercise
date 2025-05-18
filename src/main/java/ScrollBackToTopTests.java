import org.testng.Assert;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pageobject.HomePage;

public class ScrollBackToTopTests extends BaseTests {

    @Test
    @Description("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void scroll_down_and_click_ScrollBackToTopButton_should_scroll_to_top_of_website() {
        HomePage homePage = new HomePage(browser);
        homePage.runBrowser();
        homePage.scrollComponent.scrollDownToBottomOfPage();
        homePage.scrollComponent.click();

        Assert.assertTrue(homePage.scrollComponent.isLogoVisible(),
                "Logo in not visible!");
    }

    @Test
    @Description("Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    public void scroll_down_and_manually_scroll_up_should_scroll_to_top_of_website() {
        HomePage homePage = new HomePage(browser);
        homePage.runBrowser();
        homePage.scrollComponent.scrollDownToBottomOfPage();
        homePage.scrollComponent.scrollUpToTopOfPage();

        Assert.assertTrue(homePage.scrollComponent.isLogoVisible(),
                "Logo in not visible!");
    }
}
