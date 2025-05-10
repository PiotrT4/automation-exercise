import dev.failsafe.internal.util.Assert;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pageobject.BasePage;
import pageobject.CheckoutPage;
import pageobject.HomePage;
import pageobject.RegisterPage;

public class CheckoutTests extends BaseTests {

    @Test
    @Description("Test Case 23: Verify address details in checkout page")
    public void address_details_on_checkout_should_be_same_as_user_address() {
        HomePage homePage = new HomePage(browser);
        BasePage basePage1 = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInShortRegisterForm(personalData);

        RegisterPage registerPage = (RegisterPage) basePage1;

        BasePage basePage2 = registerPage
                .fillInLongRegisterForm(personalData)
                .clickCreatedAccount()
                .clickContinue(personalData.firstName)
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickContinueShopping()
                .productInteractionComponent.clickAddToCartById(productData2)
                .cartModalComponent.clickViewCart()
                .clickProceedToCheckout();

        CheckoutPage checkoutPage = (CheckoutPage) basePage2;

        Assert.isTrue(checkoutPage.isDeliveryAndBillingAddressesCorrect(personalData),
                "Delivery address or Billing Address is not correct!");

        checkoutPage.headerComponent.goToDeletedAccount().clickContinue();
    }
}
