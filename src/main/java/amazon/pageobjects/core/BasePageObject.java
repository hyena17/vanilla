package amazon.pageobjects.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageObject implements PageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForLoadedPage();
    }

}
