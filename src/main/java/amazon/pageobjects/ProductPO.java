package amazon.pageobjects;

import java.util.List;

import amazon.helper.Printer;
import amazon.helper.Scrolldown;
import amazon.pageobjects.core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPO extends BasePageObject {

    private final String LOCATOR_BASE_ABOUT_TO = "//h1[text()=' About this item ']";
    private By aboutToXpath = By.xpath("//h1[text()=' About this item ']");

    public ProductPO(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForLoadedPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOCATOR_BASE_ABOUT_TO)));
    }

    public boolean isAboutSectionPresent() {
        List<WebElement> dynamicElement = getWebDriver().findElements(aboutToXpath);
        return dynamicElement.size() > 0 ? true : false;
    }

    public void scrollToAboutToSection() {
        WebElement element = getWebDriver().findElement(aboutToXpath);
        Scrolldown.scrollDownToElement(element, getWebDriver());
    }

    public void printAboutSection() {
        List<WebElement> aboutContents = getWebDriver().findElements(By.xpath("//h1[text()=' About this item ']/parent::div//span"));
        System.out.println("About this Item:");
        Printer.printElements(aboutContents);
    }
}
