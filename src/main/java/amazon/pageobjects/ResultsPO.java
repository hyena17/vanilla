package amazon.pageobjects;

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
        WebElement sortBy = driver.findElement(xpathSortBy);
        sortBy.click();
    }

    public void clickSecondPosition() {
        clickProductOnPosition("2");
    }

    public void focusOnRecentOpenedProduct(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
    public void clickProductOnPosition(String position) {
        String productLocator = "//div[@data-index='" + position + "' and @data-component-type='s-search-result']";
        By xpathProduct = By.xpath(productLocator);
        WebElement product = driver.findElement(xpathProduct);
        product.click();

    }

    public ProductPO expectProductPO(){
        return new ProductPO(driver);
    }

}
