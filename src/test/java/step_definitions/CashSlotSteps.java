package step_definitions;

//import cucumber.api.Transform;
import io.cucumber.java.en.Then;
import support.KnowsTheDomain;
import org.junit.Assert;

public class CashSlotSteps {

    double del = 0;
    KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^(\\d+) should be dispensed$")
    public void shouldBeDispensed(int dispenseAmount) {
        int actualDispenseAmount = helper.getCashSlot().getContents();
        Assert.assertTrue("Incorrect amount (" + dispenseAmount + ") dispensed. Actual amount was: (" +
                actualDispenseAmount + ").", dispenseAmount == actualDispenseAmount);
    }

}
