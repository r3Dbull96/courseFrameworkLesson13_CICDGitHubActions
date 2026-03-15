package ui;

import Kiselev_George.pageObjects.HomePage;
import Kiselev_George.pageObjects.WebFormPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Feature("POM")
public class WebFormTestsForPOM extends BaseTest {

    @Test
    void openWebFormTestWithCheck(){
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPagePOM = homePage.openWebFormPage();

        webFormPagePOM.checkIsWebPage();
    }

    @Test
    void submitFormTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPagePOM = homePage.openWebFormPage();

        webFormPagePOM.submitForm();
        Thread.sleep(3000);
    }

    @Test
    void checkTextareaInput() {
        driver.findElement(By.xpath("//a[@href = 'web-form.html']")).click();

        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("Test\nTest2");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        WebElement h1 = driver.findElement(By.xpath("//h1[text()='Form submitted']"));
        assertEquals("Form submitted", h1.getText());
    }

    @Test
    void disabledInput() {
        driver.findElement(By.xpath("//a[@href = 'web-form.html']")).click();

        WebElement disabled = driver.findElement(By.name("my-disabled"));
        assertEquals("", disabled.getText());

        Exception thrown = assertThrows(ElementNotInteractableException.class, () -> disabled.sendKeys("Test\n"));
        assertThat(thrown.getMessage()).contains("element not interactable");
    }

}

