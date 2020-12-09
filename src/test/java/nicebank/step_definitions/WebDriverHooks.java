package nicebank.step_definitions;

import io.cucumber.java.After;
//import io.cucumber.java.Scenario;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import nicebank.implementations.support.KnowsTheDomain;

public class WebDriverHooks {

    private KnowsTheDomain helper;
    //Scenario scenario;

    public WebDriverHooks(KnowsTheDomain helper) {
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