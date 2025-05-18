import helpers.*;
import org.testng.annotations.*;

public class BaseTests {

    protected Browser browser;
    private static ConfigurationReader configurationReader;
    private static TestDataReader testDataReader;
    protected static ProductData productData1;
    protected static ProductData productData2;
    protected static ProductData productData3;
    protected static PersonalData personalData;
    protected static PaymentData paymentData;
    protected static FilePathData filePathData;

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

    private static void createFilePathData() {
        filePathData = new FilePathData(testDataReader);
    }

    @BeforeSuite
    public static void loadAndCreateTestData() {
        configurationReader = new ConfigurationReader();
        testDataReader = new TestDataReader();
        createPersonalData();
        createPaymentData();
        createFilePathData();
    }

    @BeforeMethod
    public void setup() throws NoSuchBrowserExpetion {
        BrowserFactory browserFactory = new BrowserFactory();
        browser = browserFactory.createInstance(configurationReader);
        createProductsData();
    }

    @AfterMethod
    public void quitDriver() {
        browser.driver.quit();
    }
}
