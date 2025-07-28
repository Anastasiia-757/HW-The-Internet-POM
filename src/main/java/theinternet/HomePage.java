package theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theinternet.core.BasePage;
import theinternet.pages.AlertsPage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement alertsJSLink;

    public AlertsPage selectJavaScriptAlerts() {
        click(alertsJSLink);
        return new AlertsPage(driver);
    }
}
