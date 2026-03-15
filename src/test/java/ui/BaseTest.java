package ui;

import Kiselev_George.configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Kiselev_George.patterns.factory.WebDriverFactory.createWebDriver;

public class BaseTest {
    public WebDriver driver;
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());
    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup() {
        driver = createWebDriver(configProperties.browser());
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
