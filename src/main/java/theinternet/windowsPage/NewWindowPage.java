package theinternet.windowsPage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import theinternet.core.BasePage;

public class NewWindowPage extends BasePage {

    public NewWindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
   WebElement title;



    public void verifyText(String expectedText){
        WebElement titleElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.tagName("h3")));
        Assertions.assertEquals(expectedText, titleElement.getText());
    }
}
