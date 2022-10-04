package amazon.pageobjects;

import amazon.helper.Scrolldown;
import amazon.pageobjects.core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FiltersPO extends BasePageObject {

    private final String LOCATOR_BASE_IMAGE = "//img[@alt='TV store']";

    public FiltersPO(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForLoadedPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOCATOR_BASE_IMAGE)));
    }

    public void clickOnSamsungInsideBrands() {
        clickOnCheckInsideCategory("Samsung", "Brands");
    }

    public void clickOnCheckInsideCategory(String checkboxTitle, String category) {
        scrollDownToElementByText(category);

        String xpath = "//span[text()='%s']/parent::div/following-sibling::ul//span[text()='%s']";
        By xpathElement = By.xpath(String.format(xpath, category, checkboxTitle));

        WebElement element = getWebDriver().findElement(xpathElement);
        element.click();
    }

    public void scrollDownToElementByText(String text) {
        WebElement element = getWebDriver().findElement(By.xpath("//span[text()='" + text + "']"));
        Scrolldown.scrollDownToElement(element, getWebDriver());
    }

    public ResultsPO expectResultsPO() {
        return new ResultsPO(getWebDriver());
    }

}
