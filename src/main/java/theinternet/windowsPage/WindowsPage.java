package theinternet.windowsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import theinternet.core.BasePage;

import java.util.ArrayList;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Click Here")
    WebElement ClickHereLink;

   public WindowsPage open(){
        driver.get("https://the-internet.herokuapp.com/windows");
       PageFactory.initElements(driver, this);
        return this;
    }

    @FindBy(css = "a[href='/windows/new']")
    WebElement clickHere;

    public WindowsPage clickHere(){
       click(clickHere);
       return this;
    }

    public WindowsPage switchToNewTab(int index){
        ArrayList<String>tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

}
