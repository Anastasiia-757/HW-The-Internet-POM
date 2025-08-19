package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.HomePage;
import theinternet.core.TestBase;
import theinternet.pages.DropDownPage;

public class DropDownTest extends TestBase {
    DropDownPage dropDown;

    @BeforeEach
    public void precondition() {
        dropDown = new DropDownPage(driver);
        dropDown = new HomePage(driver).selectDropdown();
    }

    @Test
    public void selectAnOptionTest() {
        dropDown.selectDropdownList("Option 1")
                .verifyText("Option 1");
    }
}
