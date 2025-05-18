import org.testng.Assert;
import helpers.RestApiRequests;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pageobject.*;

public class PlaceOrderTests extends BaseTests {

    @Test
    @Description("Test Case 14: Place Order: Register while Checkout")
    public void register_new_account_on_checkout_should_positive_create_account_order_and_delete_account() {
        RestApiRequests restApiRequests = new RestApiRequests();
        restApiRequests.deleteAccount();

        HomePage homePage = new HomePage(browser);
        BasePage basePage1 = homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickContinueShopping()
                .productInteractionComponent.clickAddToCartById(productData2)
                .cartModalComponent.clickViewCart()
                .clickProceedToCheckout();

        CartPage cartPage = (CartPage) basePage1;

        BasePage basePage2 = cartPage
                .clickRegisterOrLogin()
                .fillInShortRegisterForm(personalData);

        RegisterPage registerPage = (RegisterPage) basePage2;

        BasePage basePage3 = registerPage
                .fillInLongRegisterForm(personalData)
                .clickCreatedAccount()
                .clickContinue(personalData.firstName)
                .headerComponent.goToCart()
                .clickProceedToCheckout();

        CheckoutPage checkoutPage = (CheckoutPage) basePage3;

        checkoutPage.verifyDeliveryAddress(personalData);
        checkoutPage.verifyBillingAddress(personalData);

        DeletedAccountPage deletedAccountPage = checkoutPage
                .fillInMessage(personalData.message)
                .clickPlaceOrder()
                .fillInPaymentData(paymentData)
                .clickPayAndConfirmOrder()
                .headerComponent.goToDeletedAccount();

        Assert.assertTrue(deletedAccountPage.ifAccountDeleted(),
                "Account did not deleted!");

        deletedAccountPage.clickContinue();
    }

    @Test
    @Description("Test Case 15: Place Order: Register before Checkout")
    public void register_new_account_place_order_should_positive_create_account_order_and_delete_account() {
        RestApiRequests restApiRequests = new RestApiRequests();
        restApiRequests.deleteAccount();

        HomePage homePage = new HomePage(browser);
        BasePage basePage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInShortRegisterForm(personalData);

        RegisterPage registerPage = (RegisterPage) basePage;

        CartPage cartPage =  registerPage
                .fillInLongRegisterForm(personalData)
                .clickCreatedAccount()
                .clickContinue(personalData.firstName)
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickViewCart();

        BasePage basePage2 = cartPage.clickProceedToCheckout();

        CheckoutPage checkoutPage = (CheckoutPage) basePage2;

        checkoutPage.verifyDeliveryAddress(personalData);
        checkoutPage.verifyBillingAddress(personalData);

        DeletedAccountPage deletedAccountPage = checkoutPage
                .fillInMessage(personalData.message)
                .clickPlaceOrder()
                .fillInPaymentData(paymentData)
                .clickPayAndConfirmOrder()
                .headerComponent.goToDeletedAccount();

        Assert.assertTrue(deletedAccountPage.ifAccountDeleted(),
                "Account did not deleted!");

        deletedAccountPage.clickContinue();
    }

    @Test
    @Description("Test Case 16: Place Order: Login before Checkout")
    public void login_user_place_order_should_positive_place_order_and_delete_account() {
        RestApiRequests restApiRequests = new RestApiRequests();
        restApiRequests.createAccount();

        HomePage homePage = new HomePage(browser);
        BasePage basePage = homePage
                .runBrowser()
                .headerComponent.goToLogin()
                .fillInLoginForm(personalData)
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickViewCart()
                .clickProceedToCheckout();

        CheckoutPage checkoutPage = (CheckoutPage) basePage;

        checkoutPage.verifyDeliveryAddress(personalData);
        checkoutPage.verifyBillingAddress(personalData);

        DeletedAccountPage deletedAccountPage = checkoutPage
                .fillInMessage(personalData.message)
                .clickPlaceOrder()
                .fillInPaymentData(paymentData)
                .clickPayAndConfirmOrder()
                .headerComponent.goToDeletedAccount();

        Assert.assertTrue(deletedAccountPage.ifAccountDeleted(),
                "Account did not deleted!");

        deletedAccountPage.clickContinue();
    }

    @Test
    @Description("Test Case 24: Download Invoice after purchase order")
    public void on_place_order_page_should_positive_download_invoice() {
        RestApiRequests restApiRequests = new RestApiRequests();
        restApiRequests.deleteAccount();

        HomePage homePage = new HomePage(browser);
        BasePage basePage1 =  homePage
                .runBrowser()
                .headerComponent.goToProducts()
                .productInteractionComponent.clickAddToCartById(productData1)
                .cartModalComponent.clickContinueShopping()
                .productInteractionComponent.clickAddToCartById(productData2)
                .cartModalComponent.clickViewCart()
                .headerComponent.goToLogin()
                .fillInShortRegisterForm(personalData);

        RegisterPage registerPage = (RegisterPage) basePage1;

        BasePage basePage2 = registerPage
                .fillInLongRegisterForm(personalData)
                .clickCreatedAccount()
                .clickContinue(personalData.firstName)
                .headerComponent.goToCart()
                .clickProceedToCheckout();

        CheckoutPage checkoutPage = (CheckoutPage) basePage2;

        checkoutPage.verifyDeliveryAddress(personalData);
        checkoutPage.verifyBillingAddress(personalData);

        PlaceOrderPage placeOrderPage = checkoutPage
                .clickPlaceOrder()
                .fillInPaymentData(paymentData)
                .clickPayAndConfirmOrder()
                .clickDownloadInvoice();

        Assert.assertTrue(placeOrderPage.isInvoiceExists(filePathData.downloadFilesDirectoryPath,
                        filePathData.invoiceFileName),
                "Could not find invoice with name " + filePathData.invoiceFileName +
                        " in directory path: " + filePathData.downloadFilesDirectoryPath + "!");


        placeOrderPage.deleteInvoice(filePathData.downloadFilesDirectoryPath, filePathData.invoiceFileName);
        placeOrderPage.headerComponent.goToDeletedAccount().clickContinue();

    }
}
