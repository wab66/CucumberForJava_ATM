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

    @When("^I withdraw (\\d+)$")
    public void iWithdraw(int withdrawAmount){
        helper.getTeller().withdrawFrom(helper.getMyAccount(), withdrawAmount);
        System.out.println("[@When] > Withdraw amount from teller, teller puts into cashslot: " + helper.getCashSlot().getContents());
    }

}
