package step_definitions;

import io.cucumber.java.en.When;
import nicebank.AutomatedTeller;
import support.KnowsTheDomain;

public class TellerSteps {

    double del = 0;
    KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }
}
