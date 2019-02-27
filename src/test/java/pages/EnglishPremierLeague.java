package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static config.WebDriverSingleton.getInstance;
import static utility.Utils.*;

public class EnglishPremierLeague extends BasePage {

    public EnglishPremierLeague() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"football\"]/div/div/div/div[3]/div/div/article[1]/section/button[1]")
    private WebElement homeBet;

    @FindBy(xpath = "//div[2]/span/input")
    private WebElement betValueInput;

    @FindBy(id = "total-to-return-price")
    private WebElement totalToReturnPrice;

    @FindBy(id = "total-stake-price")
    private WebElement totalStakePrice;

    @FindBy(xpath = "//div[@class=\"betslip-selection__estimated-returns\"]/span[2]/span[2]/span")
    private WebElement estimatedReturns;

    @FindBy(xpath = "//*[@id='betslip-footer-actions']/ul/li[3]/input")
    private WebElement placeBetButton;

    @FindBy(xpath = "//*[@id='place-bet-error']/span")
    private WebElement userShuoldBeLoggedError;


    @Step
    public EnglishPremierLeague clickHomeBetButton() {
        homeBet.click();
        return this;
    }

    @Step
    public EnglishPremierLeague enterBetValue() {
        betValueInput.sendKeys("0.05");
        return this;
    }

    @Step
    public EnglishPremierLeague placeBet() {
        /*boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cookie-disclaimer")));
        if (invisible) {
        placeBetButton.click();
        }*/
        JavascriptExecutor js = (JavascriptExecutor) getInstance();
        js.executeScript("arguments[0].click()", placeBetButton);
        return this;
    }

    @Step
    public EnglishPremierLeague alertShouldBeShown() {
        userShuoldBeLoggedError.isDisplayed();
        return this;
    }

    @Step
    public EnglishPremierLeague assertBetValue() {

        Assert.assertEquals(betValueInput.getAttribute("data-ng-init") , totalStakePrice.getText());
        Assert.assertEquals(round((float)(((parse(homeBet.getText()) + 1) * parse(betValueInput.getAttribute("data-ng-init")))), 2) , Float.parseFloat(totalToReturnPrice.getText()), 0);
        Assert.assertEquals(totalToReturnPrice.getText(), estimatedReturns.getText());
        //test need modification due to possible fail if bet course gets obsolate
        return this;
    }
}