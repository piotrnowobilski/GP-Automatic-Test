package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static utility.Screenshot.captureScreenshot;


public class Football extends BasePage {

    public Football() {
        super();
    }


    @FindBy(id = "nav-football-competitions")
    private WebElement competitionsButton;


    @Step
    public Competitions openCompetions() {
        captureScreenshot();
        competitionsButton.click();
        return new Competitions();
    }
}