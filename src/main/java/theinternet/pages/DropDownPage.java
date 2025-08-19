package theinternet.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import theinternet.core.BasePage;

public class DropDownPage extends BasePage {

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public DropDownPage selectDropdownList(String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
        return this;
    }

    public DropDownPage verifyText(String expectedText) {
        String selectedOption = new Select(dropdown).getFirstSelectedOption().getText();
        Assertions.assertEquals(expectedText, selectedOption, "Element text doesn't match!");
        return this;
    }
}
