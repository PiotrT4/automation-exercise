import org.testng.Assert;
import helpers.RestApiRequests;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pageobject.CartPage;
import pageobject.HomePage;

import static org.junit.jupiter.api.Assertions.assertAll;

public class CartTests extends BaseTests {

    @Test
    @Description("Test Case 12: Add Products in Cart")
    public void add_two_products_to_cart_should_display_in_cart() {

        HomePage homePage = new HomePage(browser);
        CartPage cartPage = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickContinueShopping()
                .productInteractionComponent.clickAddToCartById(productData2)
                .cartModalComponent.clickViewCart();

        assertAll( "Verify if products are in cart:",
                () -> Assert.assertTrue(cartPage.cartCheckerComponent.isInCartById(productData1.getId()),
                        "First product is not added to cart!"),
                () -> Assert.assertTrue(cartPage.cartCheckerComponent.verifyPriceById(productData1),
                        "First product price is not correct in cart!"),
                () -> Assert.assertTrue(cartPage.cartCheckerComponent.verifyQuantityById(productData1),
                        "First product quantity is not correct in cart!"),
                () -> Assert.assertTrue(cartPage.cartCheckerComponent.verifyTotalPriceById(productData1),
                        "First product total price is not correct in cart!"),

                () -> Assert.assertTrue(cartPage.cartCheckerComponent.isInCartById(productData2.getId()),
                        "Second product is not added to cart!"),
                () -> Assert.assertTrue(cartPage.cartCheckerComponent.verifyPriceById(productData2),
                        "Second product price is not correct in cart!"),
                () -> Assert.assertTrue(cartPage.cartCheckerComponent.verifyQuantityById(productData2),
                        "Second product quantity is not correct in cart!"),
                () -> Assert.assertTrue(cartPage.cartCheckerComponent.verifyTotalPriceById(productData2),
                        "Second product total price is not correct in cart!")
        );
    }

    @Test
    @Description("Test Case 13: Verify Product quantity in Cart")
    public void add_4_quantity_of_product_should_display_4_quantity_in_cart() {

        HomePage homePage = new HomePage(browser);
        CartPage cartPage = homePage
                .runBrowser()
                .productInteractionComponent.clickViewOnRandomProduct()
                .typeQuantity(4)
                .clickAddToCart()
                .cartModalComponent.clickViewCart();

        Assert.assertTrue(cartPage.cartCheckerComponent.verifyQuantityByQuantity(4),
                "Product does not have 4 quantity!");
    }

    @Test
    @Description("Test Case 17: Remove Products From Cart")
    public void remove_product_from_cart_should_not_display_in_cart() {
        HomePage homePage = new HomePage(browser);
        CartPage cartPage = homePage
                .runBrowser()
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickViewCart()
                .removeProductById(productData1.getId());

        Assert.assertFalse(cartPage.cartCheckerComponent.isInCartById(productData1.getId()),
                "First product is still in cart after removing!");
    }

    @Test
    @Description("Test Case 20: Search Products and Verify Cart After Login")
    public void search_product_and_add_it_to_cart_should_display_in_cart_after_login() {
        RestApiRequests requests = new RestApiRequests();
        requests.createAccount();

        HomePage homePage = new HomePage(browser);
        CartPage cartPage = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .searchProduct(personalData.searchProduct)
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickViewCart();

        if ( !cartPage.cartCheckerComponent.isInCartById(productData1.getId()) ) {
            throw new RuntimeException("Product with ID " + productData1.getId() + " is not in cart before login!");
        }

        cartPage.headerComponent.goToLogin()
                .fillInLoginForm(personalData)
                .headerComponent.goToCart()
                .cartCheckerComponent.isInCartById(productData1.getId());

        Assert.assertTrue(cartPage.cartCheckerComponent.isInCartById(productData1.getId()),
                "Product with ID " + productData1.getId() + " is not in cart after login!");

        requests.deleteAccount();
    }

    @Test
    @Description("Test Case 22: Add to cart from Recommended items")
    public void add_to_cart_recommended_item_should_display_in_cart() {
        HomePage homePage = new HomePage(browser);
        CartPage cartPage = homePage
                .runBrowser()
                .addToCartRecommendedProduct(productData1)
                .cartModalComponent.clickViewCart();

        Assert.assertTrue(cartPage.cartCheckerComponent.isInCartById(productData1.getId()),
                "Recommended product with id " + productData1.getId() + " is not added to cart!");
    }
}
