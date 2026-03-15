package Kiselev_George.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    //locators
    @FindBy(className = "display-6")
    private WebElement title;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Получить текущий URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Получить заголовок страницы")
    public WebElement getTitle() {
        return driver.findElement(By.className("display-6"));
    }
}
