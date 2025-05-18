import org.testng.Assert;
import pageobject.HomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class TestCasesTests extends BaseTests {

    @Test
    @Description("Test Case 7: Verify Test Cases Page")
    public void click_test_cases_should_navigate_to_test_cases_page() {

        HomePage homePage = new HomePage(browser);
        homePage.runBrowser()
                .headerComponent.goToTestCases();

        Assert.assertEquals(browser.baseUrl + "/test_cases", browser.driver.getCurrentUrl(),
                "You are not on test cases page!");
    }

}
