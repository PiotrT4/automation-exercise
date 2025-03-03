import helpers.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    protected Browser browser;
    private static ConfigurationReader configurationReader;
    private static TestDataReader testDataReader;
    protected static ProductData productData1;
    protected static ProductData productData2;
    protected static ProductData productData3;
    protected static PersonalData personalData;
    protected static PaymentData paymentData;

    @BeforeAll
    public static void loadConfiguration() { configurationReader = new ConfigurationReader(); }

    @BeforeAll
    public static void loadAndCreateTestData() {
        testDataReader = new TestDataReader();
        createPersonalData();
        createPaymentData();
    }

    private static void createProductsData() {
        productData1 = new ProductData(testDataReader.getProduct1Id());
        productData2 = new ProductData(testDataReader.getProduct2Id());
        productData3 = new ProductData(testDataReader.getProduct3Id());
    }

    private static void createPersonalData() {
        personalData = new PersonalData(testDataReader);
    }

    private static void createPaymentData() {
        paymentData = new PaymentData(testDataReader);
    }

    @BeforeEach
    public void setup() throws NoSuchBrowserExpetion {
        BrowserFactory browserFactory = new BrowserFactory();
        browser = browserFactory.createInstance(configurationReader);
        createProductsData();
    }

    @AfterEach
    public void quitDriver() {
        browser.driver.quit();
    }
}
