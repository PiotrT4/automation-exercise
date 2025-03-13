package pageobject;

import helpers.Browser;

public class PlaceOrderPage extends BasePage {

    public final HeaderComponent headerComponent;

    public PlaceOrderPage(Browser browser) {
        super(browser);
        headerComponent = new HeaderComponent(browser);
    }

}
