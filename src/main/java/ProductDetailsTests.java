import org.testng.Assert;
import pageobject.HomePage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pageobject.ProductDetailsPage;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ProductDetailsTests extends BaseTests {

    @Test
    @Description("Test Case 8: Verify All Products and product detail page")
    public void click_view_product_should_navigate_to_product_detail_page() {

        HomePage homePage = new HomePage(browser);
        ProductDetailsPage productDetailsPage = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .productInteractionComponent.clickViewById(productData1.getId());

        assertAll( "Should verify if product details are visible:",
            () -> Assert.assertTrue(productDetailsPage.isProductNameVisible(),
                    "Product name is not visible!"),
            () -> Assert.assertTrue(productDetailsPage.isCategoryVisible(),
                    "Product category is not visible!"),
            () -> Assert.assertTrue(productDetailsPage.isAvailabilityVisible(),
                    "Product availability is not visible!"),
            () -> Assert.assertTrue(productDetailsPage.isConditionVisible(),
                    "Product condition is not visible!"),
            () -> Assert.assertTrue(productDetailsPage.isBrandVisible(),
                    "Product brand is not visible!")
        );
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
