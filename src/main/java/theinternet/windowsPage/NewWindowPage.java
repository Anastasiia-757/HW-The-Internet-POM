package theinternet.windowsPage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class NewWindowPage extends BasePage {

    public NewWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    WebElement title;

    public NewWindowPage verifyText(String expectedText) {
        Assertions.assertEquals(expectedText, title.getText());
        return this;
    }
}
