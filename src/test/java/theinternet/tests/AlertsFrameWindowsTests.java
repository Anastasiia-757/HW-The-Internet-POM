package theinternet.tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void verifyNestedFramesText() {
        frame = new HomePage(driver)
                .selectFrame()
                .selectNestedFrames();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(frame.getTextFromLeftFrame()).as("Left frame text")
                .isEqualTo("LEFT");
        softly.assertThat(frame.getTextFromMiddleFrame()).as("Middle frame text")
                .isEqualTo("MIDDLE");
        softly.assertThat(frame.getTextFromRightFrame()).as("Right frame text")
                .isEqualTo("RIGHT");
        softly.assertThat(frame.getTextFromBottomFrame()).as("Bottom frame text")
                .isEqualTo("BOTTOM");

        softly.assertAll();
        frame.returnToDefaultContent();

    }
}
