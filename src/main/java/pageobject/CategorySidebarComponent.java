package pageobject;

import helpers.Browser;
import org.openqa.selenium.By;

public class CategorySidebarComponent extends BasePage {

    private final By womenCategoryButtonLocator = By.cssSelector("#accordian a[href='#Women']");
    private final By womenCategoryPanelCollapseLocator = By.cssSelector("[id='Women'] ul");
    private final By dressSubcategoryButtonLocator = By.cssSelector("[id='Women'] a[href$='/1']");
    private final By breadcrumbsLocator = By.cssSelector(".breadcrumbs .active");
    private final By menCategoryButtonLocator = By.cssSelector("#accordian a[href='#Men']");
    private final By menCategoryPanelCollapseLocator = By.cssSelector("[id='Men'] ul");
    private final By tshirtsSubcategoryButtonLocator = By.cssSelector("[id='Men'] a[href$='/3']");

    public CategorySidebarComponent(Browser browser) {
        super(browser);
    }

    public BasePage clickWomenCategory() {
        browser.driver.findElement(womenCategoryButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(womenCategoryPanelCollapseLocator).isDisplayed());
        return this;
    }

    public CategoryProductsPage clickDressSubcategory() {
        browser.driver.findElement(dressSubcategoryButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(breadcrumbsLocator).getText().equals("Women > Dress"));
        return new CategoryProductsPage(browser);
    }

    public BasePage clickMenCategory() {
        browser.driver.findElement(menCategoryButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(menCategoryPanelCollapseLocator)).isDisplayed();
        return this;
    }

    public CategoryProductsPage clickTshirtsSubcategory() {
        browser.driver.findElement(tshirtsSubcategoryButtonLocator).click();
        browser.wait.until(driver -> driver.findElement(breadcrumbsLocator).getText().equals("Men > Tshirts"));
        return new CategoryProductsPage(browser);
    }

}
