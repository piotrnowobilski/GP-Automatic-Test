package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static config.WebDriverSingleton.getInstance;
import static utility.Screenshot.captureScreenshot;

public class Competitions extends BasePage {

    public Competitions() {
        super();
    }


    @FindBy(className = "grid-item__content-primary___56b55")
    private WebElement englishPremierLeagueButton;

    @Step
    public EnglishPremierLeague openEnglishPremierLeague() {
        captureScreenshot();

        JavascriptExecutor js = (JavascriptExecutor) getInstance();
        js.executeScript("arguments[0].click()", englishPremierLeagueButton);
        return new EnglishPremierLeague();
    }


}
