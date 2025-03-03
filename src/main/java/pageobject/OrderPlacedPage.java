package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class OrderPlacedPage extends BasePage {

    public final HeaderComponent headerComponent;

    public OrderPlacedPage(Browser browser) {
        super(browser);
        headerComponent = new HeaderComponent(browser);
    }

}
