package pageobject;

import helpers.Browser;
import helpers.PersonalData;
import helpers.ProductData;

public abstract class BasePage {

    protected Browser browser;

    public BasePage(Browser browser) {
        this.browser = browser;

    }

}
