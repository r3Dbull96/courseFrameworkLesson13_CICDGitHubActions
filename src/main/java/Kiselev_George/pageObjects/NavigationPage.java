package Kiselev_George.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationPage extends BasePage {
    private static final String NAVIGATION_URL = "navigation1.html";

    @FindBy(linkText = "Next")
    private WebElement nextButton;

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить URL страницы Navigation")
    public String getUrl() {
        return NAVIGATION_URL;
    }

    @Step("Переход на слудующую страницу")
    public void goToNextPage() {
        nextButton.click();
    }
}
