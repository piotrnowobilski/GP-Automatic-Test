package tests;

import config.TestConfig;
import org.junit.Test;
import pages.Home;

public class PlaceBet_Test extends TestConfig {

    @Test
    public void ShouldBeAbleToPlaceABetOnEnglishPremierLeague() {

        new Home()
                .openFootballPage()
                .openCompetions()
                .openEnglishPremierLeague()
                .clickHomeBetButton()
                .enterBetValue()
                .placeBet()
                .alertShouldBeShown()
                .assertBetValue();
    }

}
