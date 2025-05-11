import org.testng.Assert;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pageobject.HomePage;
import pageobject.ProductsPage;

public class ProductsTests extends  BaseTests {

    @Test
    @Description("Test Case 9: Search Product")
    public void search_product_should_print_all_product_related_to_search() {

        HomePage homePage = new HomePage(browser);
        ProductsPage productsPage = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .searchProduct(personalData.searchProduct);

        Assert.assertTrue(productsPage.isAllProductsOnListVisible(),
                "Some products are not visible on product page or search did not find any product!");
    }
}
