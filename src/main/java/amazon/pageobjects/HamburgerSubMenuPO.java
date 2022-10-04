package amazon.pageobjects;

import amazon.helper.Wait;
import amazon.pageobjects.core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HamburgerSubMenuPO extends BasePageObject {
    private final String BASE_LOCATOR = "//div[text()='tv, audio & cameras']";
    public HamburgerSubMenuPO(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForLoadedPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BASE_LOCATOR)));
    }

    public void clickOnTelevisionInsideTvAudiosCamera() {
        String product = "Televisions";
        String subSection = "tv, audio & cameras";
        clickOnSubsectionProduct(product, subSection);
    }

    public void clickOnSubsectionProduct(String product, String subSectionTitle) {
        By xpath = By.xpath("//div[text()='" + subSectionTitle + "']//parent::li//parent::ul//a[text()='" + product + "']");
        Wait.waitForElementByXpath(wait, xpath);
        WebElement subSection = getWebDriver().findElement(xpath);
        subSection.click();
    }

    public FiltersPO expectFiltersPO(){
        return new FiltersPO(getWebDriver());
    }

}
