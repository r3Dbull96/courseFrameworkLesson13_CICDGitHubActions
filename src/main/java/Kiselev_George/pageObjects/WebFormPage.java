package Kiselev_George.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Kiselev_George.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    //locators
    WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить URL страницы Web Form")
    public String getUrl() {
        return WEB_FORM_URL;
    }

    @Step("Отправить форму")
    public void submitForm() {
        submitButton.click();
    }

    @Step("Проверка что эта страница Web Form")
    public void checkIsWebPage() {
        assertEquals(BASE_URL + getUrl(), getCurrentUrl());
        assertEquals("Web form", getTitle().getText());
    }
}
