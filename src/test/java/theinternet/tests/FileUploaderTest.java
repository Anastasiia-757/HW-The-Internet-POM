package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.HomePage;
import theinternet.core.TestBase;
import theinternet.pages.FileUploaderPage;

public class FileUploaderTest extends TestBase {
    FileUploaderPage fileUploader;

    @BeforeEach
    public void precondition() {
        fileUploader = new FileUploaderPage(driver);
        new HomePage(driver).selectFileUploaderLink();
    }

    @Test
    public void uploadFileTest() {
        fileUploader.uploadFile("C:/Tools/girafe.jpg")
                .submitUploadForm()
                .verifySuccessUploaded("File Uploaded!");
    }
}
