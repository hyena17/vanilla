package amazon;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pageobjects.FiltersPO;
import amazon.pageobjects.HamburgerSubMenuPO;
import amazon.pageobjects.HamburguerMenuPO;
import amazon.pageobjects.HomePagePO;
import amazon.pageobjects.ProductPO;
import amazon.pageobjects.ResultsPO;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    @BeforeEach
    public void beforeMethod() {
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterMethod() {
        driver.quit();
    }

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
    }

    @Tag("smokeTest")
    @DisplayName("This test verifies E2E flow from home page through seach and product page")
    @Test
    void assertCustomer() {
        HomePagePO homepage = new HomePagePO(driver);
        homepage.clickOnHamburgerMenu();
        HamburguerMenuPO hamburgerMenu = homepage.expectHamburgerMenuPO();
        hamburgerMenu.clickOnTvAppliancesAndElectronicsInsideShopByCategory();
        HamburgerSubMenuPO hamburgerSubsectionMenu = hamburgerMenu.expectHamburgerSubMenuPO();
        hamburgerSubsectionMenu.clickOnTelevisionInsideTvAudiosCamera();
        FiltersPO filtersPO = hamburgerSubsectionMenu.expectFiltersPO();
        filtersPO.clickOnSamsungInsideBrands();
        ResultsPO resultPO = filtersPO.expectResultsPO();
        resultPO.clickFilter();
        resultPO.sortByHighToLow();
        resultPO.clickSecondPosition();
        resultPO.focusOnRecentOpenedProduct();
        ProductPO productPO = resultPO.expectProductPO();
        assertEquals(true, productPO.isAboutSectionPresent());
        productPO.scrollToAboutToSection();
        productPO.printAboutSection();
    }


}
