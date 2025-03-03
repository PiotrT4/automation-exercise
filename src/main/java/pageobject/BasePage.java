package pageobject;

import helpers.Browser;

public abstract class BasePage {

    protected Browser browser;

    public BasePage(Browser browser) {
        this.browser = browser;

    }

}
