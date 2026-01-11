package Hooks;

import BaseClass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class HooksClass extends BaseClass {

//    @After
//    public void tearDown(Scenario scenario) {
//
//        if (scenario.isFailed()) {
//            byte[] screenshot = ((TakesScreenshot) driver)
//                    .getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "Failed Screenshot");
//        }
//
//        quitBrowser();
//    }
}
