package theinternet.pages.interactions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;
    @FindBy(id = "column-b")
    WebElement columnB;

    public DragAndDropPage actionDragAndDrop() {
        actions.dragAndDrop(columnA,columnB).perform();
        return this;
    }

    public DragAndDropPage verifyColumnText(String text) {
        Assertions.assertTrue(isContainsText(text, columnB));
        return this;
    }
}
