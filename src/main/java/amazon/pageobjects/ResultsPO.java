package amazon.pageobjects;

import amazon.helper.Sleep;
import amazon.helper.Wait;
import amazon.pageobjects.core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class ResultsPO extends BasePageObject {

    private final String LOCATOR_BASE_SUBTITLE = "//span[text()='RESULTS']";
    @FindBy(xpath = "//span[@class='a-dropdown-label' and text()='Sort by:']")
    private WebElement filter;

    public ResultsPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @Override
    public void waitForLoadedPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOCATOR_BASE_SUBTITLE)));
    }

    public void clickFilter() {
        filter.click();
    }

    public void sortByHighToLow() {
        sortBy("Price: High to Low");
    }

    public void sortBy(String type) {
        String sortByTypeLocator = "//a[text()='" + type + "']";
        By xpathSortBy = By.xpath(sortByTypeLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathSortBy));
        WebElement sortBy = getWebDriver().findElement(xpathSortBy);
        sortBy.click();
    }

    public void clickSecondPosition() {
        waitForProductInPosition("2");
        clickProductOnPosition("2");
    }

    public void waitForProductInPosition(String position){
        String productLocator = "//div[@data-index='"+position+"' and @data-component-type='s-search-result']";
        By xpathProduct = By.xpath(productLocator);
        Wait.waitForElementByXpath(wait, xpathProduct);
    }

    public void focusOnRecentOpenedProduct(){
        int count = 0;
        int MAX_ITERATIONS = 5;
        while(count++<MAX_ITERATIONS){
            ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
            if(tabs.size()>1){
                break;
            }
            Sleep.sleep(1000);
        }

        ArrayList<String> tabs = new ArrayList<>(getWebDriver().getWindowHandles());
        getWebDriver().switchTo().window(tabs.get(1));
    }
    public void clickProductOnPosition(String position) {
        String productLocator = "//div[@data-index='" + position + "' and @data-component-type='s-search-result']";
        By xpathProduct = By.xpath(productLocator);
        WebElement product = getWebDriver().findElement(xpathProduct);
        product.click();

    }

    public ProductPO expectProductPO(){
        return new ProductPO(getWebDriver());
    }

}
