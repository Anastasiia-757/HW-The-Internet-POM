package theinternet.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void scrollWithJs(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickWithJs(WebElement element, int x, int y) {
        scrollWithJs(x, y);
        element.click();
    }

    public boolean isContainsText(String userName, WebElement element) {
        return element.getText().contains(userName);
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void shouldHaveText(WebElement element, String expectedText) {
        String actualText = element.getText();

        Assertions.assertEquals(expectedText, actualText, "Element text doesn't match!");
    }
}
