package ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTests extends BaseTest {
    @Test
    void openHomePageTest(){
        String actualTitle = driver.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}
