package utils;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenShotUtil.captureScreenshot(scenario.getName());
            // CHAMADA AQUI
        }
        else {
            ScreenShotUtil.captureScreenshot(scenario.getName());
        }

        PlaywrightFactory.close(); // Fecha o navegador
    }
}
