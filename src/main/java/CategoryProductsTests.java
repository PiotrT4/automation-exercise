import dev.failsafe.internal.util.Assert;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pageobject.BasePage;
import pageobject.CategoryProductsPage;
import pageobject.CategorySidebarComponent;
import pageobject.HomePage;

public class CategoryProductsTests extends BaseTests  {
    @Test
    @Description("Test Case 18: View Category Products")
    public void view_category_products_should_display_products_in_that_category() {
        HomePage homePage = new HomePage(browser);
        BasePage basePage1 = homePage
                .runBrowser()
                .categorySidebarComponent.clickWomenCategory();

        CategorySidebarComponent categorySidebarComponent1 = (CategorySidebarComponent) basePage1;

        BasePage basePage2 = categorySidebarComponent1
                .clickDressSubcategory()
                .categorySidebarComponent.clickMenCategory();

        CategorySidebarComponent categorySidebarComponent2 = (CategorySidebarComponent) basePage2;

        CategoryProductsPage categoryProductsPage = categorySidebarComponent2
                .clickTshirtsSubcategory();

        Assert.isTrue(categoryProductsPage.isMenTshirtsCategoryTitleDisplayed(),
                "T-shirts category is not displayed!");
    }
}
