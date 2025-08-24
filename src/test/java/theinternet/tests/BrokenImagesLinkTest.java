package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.HomePage;
import theinternet.core.TestBase;
import theinternet.pages.BrokenImagesPage;

public class BrokenImagesLinkTest extends TestBase {
    BrokenImagesPage brokenImages;

    @BeforeEach
    public void precondition() {
        brokenImages = new BrokenImagesPage(driver);
        new HomePage(driver).selectBrokenImagesLink();
    }

    @Test
    public void checkBrokenLinksTest() {
        brokenImages.checkBrokenImagesLinks();
    }
}
