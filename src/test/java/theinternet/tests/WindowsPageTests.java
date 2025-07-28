package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.TestBase;
import theinternet.windowsPage.NewWindowPage;
import theinternet.windowsPage.WindowsPage;

public class WindowsPageTests extends TestBase {
    WindowsPage windowsPage;

    @BeforeEach
    public void precondition() {
        windowsPage = new WindowsPage(driver);
        windowsPage.open();
    }


    @Test
    public void newWindowOpen(){
        windowsPage.clickHere()
                .switchToNewTab(1);

        NewWindowPage newWindowPage = new NewWindowPage(driver);
        newWindowPage.verifyText("New Window");
    }
}
