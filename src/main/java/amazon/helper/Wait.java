package amazon.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static void waitForElementByXpath(WebDriverWait wait, By xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

}
