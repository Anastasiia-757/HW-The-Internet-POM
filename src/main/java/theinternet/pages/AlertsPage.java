package theinternet.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theinternet.core.BasePage;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertLink;

    public AlertsPage clickJSAlerts() {
        click(jsAlertLink);
        return this;
    }

    public AlertsPage verifyAlertText(String expectedText) {
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        Assertions.assertEquals(expectedText, actualText);
        return this;
    }

    public AlertsPage confirmAlert() {
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "result")
    WebElement result;

    public AlertsPage verifyResultText(String expected) {
        Assertions.assertEquals(expected, result.getText());
        return this;
    }

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement JSConfirmButton;

    public AlertsPage selectJSConfirmAndChoose(String choice) {
        click(JSConfirmButton);
        Alert alert = driver.switchTo().alert();
        if (choice == null || choice.equalsIgnoreCase("OK")) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return this;
    }

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement JSPromptButton;

    public AlertsPage clickJSPromptAndEnteredText(String text) {
        click(JSPromptButton);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        return this;
    }
}
