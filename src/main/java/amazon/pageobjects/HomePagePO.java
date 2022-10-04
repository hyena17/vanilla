package amazon.pageobjects;
import amazon.helper.Wait;
import amazon.pageobjects.core.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePagePO extends BasePageObject {

    private final String LOCATOR_HAMBURGER_MENU_ID = "nav-hamburger-menu";
    @FindBy(id="nav-hamburger-menu")
	private WebElement hamburgerMenu;
    public HomePagePO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
	}

    @Override
    public void waitForLoadedPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LOCATOR_HAMBURGER_MENU_ID)));
    }

    public void clickOnHamburgerMenu() {
        Wait.waitForElementByXpath(wait, By.id(LOCATOR_HAMBURGER_MENU_ID));
		hamburgerMenu.click();
	}

    public HamburguerMenuPO expectHamburgerMenuPO(){
        return new HamburguerMenuPO(getWebDriver());
    }



}
