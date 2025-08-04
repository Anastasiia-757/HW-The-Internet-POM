package theinternet.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import theinternet.HomePage;
import theinternet.core.TestBase;
import theinternet.pages.AlertsPage;
import theinternet.pages.FramePage;

public class AlertsFrameWindowsTests extends TestBase {

    AlertsPage alerts;
    FramePage frame;

    @BeforeEach
    public void precondition() {
        alerts = new HomePage(driver).selectJavaScriptAlerts();
        frame = new FramePage(driver);
        new HomePage(driver).selectFrame().selectNestedFrames();
    }

    @Test
    public void verifyJavaScriptAlert() {
        alerts.clickJSAlerts()
                .verifyAlertText("I am a JS Alert")
                .confirmAlert()
                .verifyResultText("You successfully clicked an alert");
    }

    @Test
    public void clickJSConfirm() {
        alerts.selectJSConfirmAndChoose("Cancel")
                .verifyResultText("You clicked: Cancel");
    }

    @Test
    public void clickJSPromptAndEnteredText() {
        alerts.clickJSPromptAndEnteredText("What's up?")
                .verifyResultText("You entered: What's up?");
    }

    @Test
    public void verifyNestedFramesText(){
        frame=new HomePage(driver)
                .selectFrame()
                .selectNestedFrames();
        Assertions.assertEquals("LEFT", frame.getTextFromLeftFrame());
        Assertions.assertEquals("MIDDLE", frame.getTextFromMiddleFrame());
        Assertions.assertEquals("RIGHT", frame.getTextFromRightFrame());
        Assertions.assertEquals("BOTTOM", frame.getTextFromBottomFrame());
    }
}
