package theinternet.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import theinternet.core.BasePage;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/horizontal_slider']")
    WebElement horizontalSlider;

    public SliderPage selectSlider() {
        clickWithJs(horizontalSlider, 0, 500);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//input[@type='range']")
    WebElement sliderInput;

    public SliderPage moveSliderInHorizontalDirection() {
        scrollWithJs(0, 200);
        actions.dragAndDropBy(sliderInput, 64, 0).perform();
        return this;
    }

    @FindBy(id = "range")
    WebElement range;

    public SliderPage verifySliderValue(String number) {
        Assertions.assertEquals(number, range.getText());
        return this;
    }
}
