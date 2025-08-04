package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import theinternet.core.BasePage;

public class FramePage extends BasePage {

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromLeftFrame() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String text = driver.findElement(By.tagName("body")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public String getTextFromMiddleFrame() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String text = driver.findElement(By.id("content")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public String getTextFromRightFrame(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        String text = driver.findElement(By.tagName("body")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public String getTextFromBottomFrame(){
        driver.switchTo().frame("frame-bottom");
        String text = driver.findElement(By.tagName("body")).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}
