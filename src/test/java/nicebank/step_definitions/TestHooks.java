package nicebank.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestHooks {
    @Before
    public void beforeCallingScenario() {
        System.out.println("*********** About to start the scenario.");
    }

    @After
    public void afterRunningScenario(Scenario scenario) {
        System.out.println("*********** Just finished running scenario: "
                + scenario.getStatus());
    }
}