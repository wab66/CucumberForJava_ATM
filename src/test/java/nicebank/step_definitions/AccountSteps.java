
package nicebank.step_definitions;

import nicebank.implementations.support.KnowsTheDomain;
import nicebank.AutomatedTeller;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountSteps {

	double del = 0;
	KnowsTheDomain helper;

	public AccountSteps() {
		helper = new KnowsTheDomain();
	}

	@Given("^my (.*?) account has been credited (\\d+\\.\\d\\d)?")
	public void myAccountHasBeenCredited(String account, float creditAmount) {
		//Account account = new Account();
		//account.deposit(depositAmount);
		helper.getMyAccount().credit(creditAmount);
		Assert.assertEquals("Incorrect account balance", creditAmount, helper.getMyAccount().getAccountBalance(), del);
	}

	@When("^I transfer (\\d+\\.\\d\\d) from my (.*?) Account to my (.*?) Account?")
	public void iTransferFromMyAccountToMyAccount(float transferAmount, String fromAccount, String toAccount) {
	    throw new io.cucumber.java.PendingException();
	}

	// ToDo: The following 2 could be just on Then - "^the (.*?) Account will be (\\d+\\.\\d\\d)?"

	@Then("^the (.*?) Account will be (\\d+\\.\\d\\d) more?")
	public void theChequeAccountWillBeMore(String fromAccount, float amount) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

    @Then("^the (.*?) Account will be (\\d+\\.\\d\\d) less?")
    public void theAccountWillBeLess(String fromAccount, float amount) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

	// Cash Withdrawl -
	@When("^I withdraw (\\d+\\.\\d\\d)$")
	public void iWithdraw(float withdrawAmount) throws Throwable {
		AutomatedTeller automatedTeller = new AutomatedTeller(helper.getCashSlot());
		helper.getTeller().withdrawFrom(helper.getMyAccount(), withdrawAmount);
	}
	
	@Then("^(\\d+\\.\\d\\d) should be dispensed$")
	public void shouldBeDispensed(float dispenseAmount) throws Throwable {
		Assert.assertEquals("Incorrect amount dispensed.", dispenseAmount, helper.getCashSlot().getContents(),del);
	}

    @Then("^the balance of my (.*?) account should be (\\d+\\.\\d\\d)?")
    public void theBalanceOfMyAccountShouldBe(String fromAccount, float accountBalance) {
        Assert.assertEquals("Incorrect account balance", accountBalance, helper.getMyAccount().getAccountBalance(), del);
    }
}

// mvn exec:java -Dexec.mainClass =" nicebank.AtmServer"
