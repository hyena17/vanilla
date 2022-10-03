package amazon.pageobjects;
import amazon.pageobjects.core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagePO extends BasePageObject {
	@FindBy(id="nav-hamburger-menu")
	private WebElement hamburguerMenu;
    public HomePagePO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
	}

    @Override
    public void waitForLoadedPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-hamburger-menu")));
    }

    public void clickOnHamburguerMenu() {
		hamburguerMenu.click();
	}

    public HamburguerMenuPO expectHamburguerMenuPO(){
        return new HamburguerMenuPO(driver);
    }



}
