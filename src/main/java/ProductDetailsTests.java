import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pageobject.HomePage;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pageobject.ProductDetailsPage;

public class ProductDetailsTests extends BaseTests {

    @Test
    @Description("Test Case 8: Verify All Products and product detail page")
    public void click_view_product_should_navigate_to_product_detail_page() {

        HomePage homePage = new HomePage(browser);
        ProductDetailsPage productDetailsPage = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .productInteractionComponent.clickViewById(productData1.getId());

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(productDetailsPage.isProductNameVisible(),
                    "Product name is not visible!");
        softAssert.assertTrue(productDetailsPage.isCategoryVisible(),
                    "Product category is not visible!");
        softAssert.assertTrue(productDetailsPage.isAvailabilityVisible(),
                    "Product availability is not visible!");
        softAssert.assertTrue(productDetailsPage.isConditionVisible(),
                    "Product condition is not visible!");
        softAssert.assertTrue(productDetailsPage.isBrandVisible(),
                    "Product brand is not visible!");

        softAssert.assertAll();
    }

    @Test
    @Description("Test Case 21: Add review on product")
    public void add_review_to_product_should_disply_success_message() {
        HomePage homePage = new HomePage(browser);
        ProductDetailsPage productDetailsPage = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .productInteractionComponent.clickViewOnRandomProduct()
                .fillInReviewForm(personalData)
                .clickSubmit();

        Assert.assertTrue(productDetailsPage.ifReviewSucessMessageDisplyed(),
                "Review success message was not displayed!");
    }
}
