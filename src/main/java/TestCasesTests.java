import pageobject.HomePage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCasesTests extends BaseTests {

    @Test
    @Description("Test Case 7: Verify Test Cases Page")
    public void click_test_cases_should_navigate_to_test_cases_page() {

        HomePage homePage = new HomePage(browser);
        homePage.runBrowser()
                .headerComponent.goToTestCases();

        Assertions.assertEquals(browser.baseUrl + "/test_cases", browser.driver.getCurrentUrl(),
                "You are not on test cases page!");
    }

}
