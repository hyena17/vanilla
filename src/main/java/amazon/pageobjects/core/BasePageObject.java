package amazon.pageobjects.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageObject implements PageObject {

    private WebDriver driver;
    protected WebDriverWait wait;
    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitForLoadedPage();
    }

    public WebDriver getWebDriver(){
        return driver;
    }

}
