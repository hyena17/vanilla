package amazon.pageobjects;

import amazon.pageobjects.core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HamburguerMenuPO extends BasePageObject {
    private final String BASE_LOCATOR = "//div[@id='hmenu-canvas']";

    public HamburguerMenuPO(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForLoadedPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BASE_LOCATOR)));
    }

    public void clickOnTvAppliancesAndElectronicsInsideShopByCategory() {
        String section = "shop by category";
        String subSection = "TV, Appliances, Electronics";
        clickOnSubsection(section, subSection);
    }

    public void clickOnSubsection(String section, String subSection) {
        WebElement element = getWebDriver()
                .findElement(By.xpath("//div[text()='" + subSection + "']"));
        element.click();
    }

    public HamburgerSubMenuPO expectHamburgerSubMenuPO(){
        return new HamburgerSubMenuPO(getWebDriver());
    }

}
