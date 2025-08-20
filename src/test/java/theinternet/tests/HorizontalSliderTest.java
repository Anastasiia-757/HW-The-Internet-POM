package theinternet.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import theinternet.core.TestBase;
import theinternet.pages.SliderPage;

public class HorizontalSliderTest extends TestBase {
    SliderPage slider;

    @BeforeEach
    public void precondition() {
        slider = new SliderPage(driver);
    }

    @Test
    public void sliderTest() {
        slider.selectSlider();
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .verifySliderValue("5");
    }
}
