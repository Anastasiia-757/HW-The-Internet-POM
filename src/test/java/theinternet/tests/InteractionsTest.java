package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.HomePage;
import theinternet.core.TestBase;
import theinternet.pages.interactions.DragAndDropPage;

public class InteractionsTest extends TestBase {
    DragAndDropPage dragAndDrop;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectDragAndDropLink();
        dragAndDrop = new DragAndDropPage(driver);
    }

    @Test
    public void actionDragAndDrop(){
        dragAndDrop.actionDragAndDrop()
                .verifyColumnText("A");
    }
}
