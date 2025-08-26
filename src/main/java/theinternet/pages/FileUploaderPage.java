package theinternet.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class FileUploaderPage extends BasePage {

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "file-upload")
    WebElement fileUpload;

    public FileUploaderPage uploadFile(String path) {
        fileUpload.sendKeys(path);
        return this;
    }

    @FindBy(id = "file-submit")
    WebElement submit;

    public FileUploaderPage submitUploadForm() {
        click(submit);
        return this;
    }

    @FindBy(css = "h3")
    WebElement headerTitle;

    public FileUploaderPage verifySuccessUploaded(String title) {
        Assertions.assertTrue(headerTitle.getText().equals(title));
        return this;
    }
}
