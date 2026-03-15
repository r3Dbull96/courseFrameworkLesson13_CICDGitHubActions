package ui;

import Kiselev_George.pageObjects.HomePage;
import Kiselev_George.pageObjects.NavigationPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("POM")
public class NavigationTestsForPOM extends BaseTest {

    @Test
    void openNavigationTest(){
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String webFormUrl = navigationPage.getUrl();

        navigationPage.goToNextPage();


        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Navigation example", title.getText());
    }

}
