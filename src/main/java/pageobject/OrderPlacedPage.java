package pageobject;

import helpers.Browser;

public class OrderPlacedPage extends BasePage {

    public final HeaderComponent headerComponent;

    public OrderPlacedPage(Browser browser) {
        super(browser);
        headerComponent = new HeaderComponent(browser);
    }

}
