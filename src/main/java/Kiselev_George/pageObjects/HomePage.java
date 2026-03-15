package Kiselev_George.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    //actions
    @Step("Открыть домашнюю страницу")
    private void open() {
        driver.get(BASE_URL);
    }

    @Step("Получить заголовок страницы Web Form")
    public String getWebTitle() {
        return driver.getTitle();
    }

    //methods
    @Step("Открыть страницу Web Form")
    public WebFormPage openWebFormPage() {
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver);
    }

    @Step("Открыть страницу Navigation")
    public NavigationPage openNavigationPage() {
        driver.findElement(By.linkText("Navigation")).click();
        return new NavigationPage(driver);
    }
}
