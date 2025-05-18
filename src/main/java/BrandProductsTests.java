import org.testng.Assert;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pageobject.BrandProductsPage;
import pageobject.HomePage;

public class BrandProductsTests extends BaseTests {

    @Test
    @Description("Test Case 19: View & Cart Brand Products")
    public void view_brand_products_should_display_products_from_that_brand() {
        HomePage homePage = new HomePage(browser);
        BrandProductsPage brandProductsPage = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .brandsSidebarComponent.clickPoloBrand()
                .brandsSidebarComponent.clickHMBrand();

        Assert.assertTrue(brandProductsPage.ifBrandProductsDisplayed(),
                "Brand products did not displayed!");
    }
}
