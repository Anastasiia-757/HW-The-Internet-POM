package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import theinternet.HomePage;
import theinternet.core.TestBase;
import theinternet.pages.AlertsPage;

public class AlertsFrameWindowsTests extends TestBase {

    AlertsPage alerts;

    @BeforeEach
    public void precondition() {
        alerts = new HomePage(driver).selectJavaScriptAlerts();
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
}
