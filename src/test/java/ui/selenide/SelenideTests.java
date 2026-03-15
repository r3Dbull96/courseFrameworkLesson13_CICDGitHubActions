package ui.selenide;

import Kiselev_George.selenidePages.HomePage;
import Kiselev_George.selenidePages.WebFormPage;
import org.junit.jupiter.api.Test;

import static Kiselev_George.pageObjects.HomePage.BASE_URL;
import static com.codeborne.selenide.Condition.value;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenideTests {

    @Test
    void openHomePageTest() {
        HomePage homePage = new HomePage();
        homePage.open();

        assertEquals(BASE_URL, homePage.getCurrentUrl());
    }

    @Test
    void openWebFormPageTest() {
        HomePage homePage = new HomePage();
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        assertEquals(BASE_URL + webFormPage.getWebFormExpectedUrl(), webFormPage.getCurrentUrl());
        assertEquals("Hands-On Selenium WebDriver with Java", webFormPage.getWebTitle());
    }

    @Test
    void readonlyTextTest() {
        HomePage homePage = new HomePage();
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.getReadonlyInput().shouldHave(value("Readonly input"));
    }
}
