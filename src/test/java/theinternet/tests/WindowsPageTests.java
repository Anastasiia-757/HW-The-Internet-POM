package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.windowsPage.NewWindowPage;
import theinternet.windowsPage.WindowsPage;

public class WindowsPageTests extends TestBase {
    WindowsPage windowsPage;

    @BeforeEach
    public void precondition() {
        driver.get("https://the-internet.herokuapp.com/windows");
        windowsPage = new WindowsPage(driver);
    }


    @Test
    public void newWindowOpen() {
        windowsPage.clickHere()
                .switchToNewTab(1);

        new NewWindowPage(driver).verifyText("New Window");
    }
}
