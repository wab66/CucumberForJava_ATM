package step_definitions.hooks;

import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
import io.cucumber.java.Scenario;
import support.KnowsTheDomain;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class HooksWebDriver {

    private KnowsTheDomain helper;
    //Scenario scenario;

    public HooksWebDriver(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @After
    public void finish(Scenario scenario) {
        System.out.println("*********** [WebDriverHooks] > [@After] > [finish]: Take screen shot");
        try {
            TakesScreenshot ts = (TakesScreenshot) helper.getWebDriver();
            //byte[] screenshot =  helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            byte[] screenshot =  ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","Out_WebDriverHooks");
            System.out.println("[WebDriverHooks] > [@After] > [finish()] > Screen shot taken");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            helper.getWebDriver().close();
        }
    }
}