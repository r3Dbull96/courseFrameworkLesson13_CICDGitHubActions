package ui;

import Kiselev_George.pageObjects.HomePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("POM")
class HomePageTestsWithPOMTests extends BaseTest {

    @Test
    void openHomePageTest(){
        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}