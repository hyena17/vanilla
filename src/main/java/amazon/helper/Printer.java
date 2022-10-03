package amazon.helper;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Printer {

    public static void printElements(List<WebElement> list){
        for (WebElement element : list) {
            System.out.println(element.getAttribute("innerHTML"));
        }
    }

}
