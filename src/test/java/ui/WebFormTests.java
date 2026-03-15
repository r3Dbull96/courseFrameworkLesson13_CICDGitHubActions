package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WebFormTests extends BaseTest {

    @Test
    void openWebFormTest(){
        driver.findElement(By.xpath("//a[@href = 'web-form.html']")).click();

        String webFormUrl = "web-form.html";
        String currentUrl = driver.getCurrentUrl();

        WebElement webFormTitle = driver.findElement(By.className("display-6"));
        String currentTitle = "Web form";

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals(currentTitle, webFormTitle.getText());
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
