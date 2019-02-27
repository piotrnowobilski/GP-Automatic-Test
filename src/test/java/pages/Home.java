package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;

public class Home extends BasePage {

    public Home() {
        super();
    }

    @FindBy(css = "[title=\"Football\"]")
    private WebElement footballPageButton;

    @Step
    public Football openFootballPage() {
        footballPageButton.click();
        captureScreenshot();

        return new Football();
    }
}
