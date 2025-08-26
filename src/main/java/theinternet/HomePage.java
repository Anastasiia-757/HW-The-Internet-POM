package theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import theinternet.core.BasePage;
import theinternet.pages.*;
import theinternet.pages.interactions.DragAndDropPage;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement alertsJSLink;

    public AlertsPage selectJavaScriptAlerts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(alertsJSLink));
        click(alertsJSLink);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[.='Frames']")
    WebElement frame;

    public HomePage selectFrame() {
        driver.get("https://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(frame)).click();
        return this;
    }

    @FindBy(xpath = "//a[text()='Nested Frames']")
    WebElement nestedFrames;

    public FramePage selectNestedFrames() {
        click(nestedFrames);
        return new FramePage(driver);
    }

    @FindBy(xpath = "//a[.='Dropdown']")
    WebElement dropdown;

    public DropDownPage selectDropdown() {
        click(dropdown);
        return new DropDownPage(driver);
    }

    @FindBy(xpath = "//a[@href='/drag_and_drop']")
    WebElement dragAndDropLink;

    public DragAndDropPage selectDragAndDropLink() {
        click(dragAndDropLink);
        return new DragAndDropPage(driver);
    }

    @FindBy(xpath = "//a[@href='/broken_images']")
    WebElement brokenImages;

    public BrokenImagesPage selectBrokenImagesLink() {
        click(brokenImages);
        return new BrokenImagesPage(driver);
    }
    @FindBy(xpath = "//a[@href='/upload']")
    WebElement upload;

    public FileUploaderPage selectFileUploaderLink() {
        click(upload);
        return new FileUploaderPage(driver);
    }
}
