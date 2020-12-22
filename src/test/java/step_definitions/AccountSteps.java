
package step_definitions;

//import cucumber.api.Transform;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nicebank.AutomatedTeller;
import nicebank.Money;
import support.KnowsTheDomain;
import org.junit.Assert;

public class AccountSteps {

	double del = 0;
	KnowsTheDomain helper;

	public AccountSteps() {
		helper = new KnowsTheDomain();
	}

	/*@ParameterType(".*")
	public Money money(String moneyAmount) {
		return new Money(moneyAmount);
	}*/

//--------------------------------------------------------------------------------------------------------------------
//	Desc:
//	The ATM posts messages about transactions into the Transaction Queue. The Transaction Processor reads messages off
//	that queue, reads the existing balance from the Balance Store, and then stores the updated balance back
//	in the Balance Store. The ATM reads the account balance from the Balance Store.
//--------------------------------------------------------------------------------------------------------------------

	@ParameterType(name = "deposit", value = "\\d+\\.\\d+")
	public Money defineAmount(String value) {
		return new Money(value);
	}

	@Given("^my (.*?) account has been credited (\\d+\\.\\d\\d)?")
	//@Given("^my (.*?) account has been credited {deposit}?")
	public void myAccountHasBeenCredited(String account, Money deposit) throws Throwable {
	//public void myAccountHasBeenCredited(String account, @Transform(MoneyConverter.class) Money creditAmount) throws Throwable {
		helper.getMyAccount().credit(deposit);
		Assert.assertFalse("Incorrect account balance, expected: " + deposit + ", but actual was: " + helper.getMyAccount().getAccountBalance(), (deposit == helper.getMyAccount().getAccountBalance()));
	}

	@When("^I withdraw (\\d+)$")
	public void
	iWithdraw(int withdrawAmount){
		AutomatedTeller automatedTeller = new AutomatedTeller(helper.getCashSlot());
		helper.getTeller().withdrawFrom(helper.getMyAccount(), withdrawAmount);
		automatedTeller.withdrawFrom(helper.getMyAccount(), withdrawAmount);
		System.out.println("debug");
	}

	@When("^I transfer (\\d+\\.\\d\\d) from my (.*?) Account to my (.*?) Account?")
	public void iTransferFromMyAccountToMyAccount(float transferAmount, String fromAccount, String toAccount) {
	    //throw new io.cucumber.java.PendingException();
		System.out.println("ToDo: When - iTransferFromMyAccountToMyAccount");
	}

	// ToDo: The following 2 could be just on Then - "^the (.*?) Account will be (\\d+\\.\\d\\d)?"

	@Then("^(\\d+) should be dispensed$")
	public void shouldBeDispensed(int dispenseAmount) {
		int actualDispense = helper.getCashSlot().getContents();
		Assert.assertTrue("Incorrect amount ( + dispenseAmount + ) dispensed.", dispenseAmount == actualDispense);
	}

	@Then("^the (.*?) Account will be (\\d+\\.\\d\\d) more?")
	public void theChequeAccountWillBeMore(String fromAccount, float amount) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		System.out.println("ToDo: Then - theChequeAccountWillBeMore");
	}

	@Then("^the (.*?) Account will be (\\d+\\.\\d\\d) less?")
	public void theAccountWillBeLess(String fromAccount, float amount) {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		System.out.println("ToDo: Then - theAccountWillBeLess");
	}

//	@Then("^the balance of my (.*?) account should be {accountBalance}?")
//	public void theBalanceOfMyAccountShouldBe(String fromAccount, Money accountBalance) {
	@Then("^the balance of my (.*?) account should be (\\d+\\.\\d\\d)?")
    public void theBalanceOfMyAccountShouldBe(String fromAccount, Money accountBalance) throws InterruptedException {
		int timeoutMilliSecs = 3000;
		int pollIntervalMilliSecs = 100;

		while (!helper.getMyAccount().getAccountBalance().equals(accountBalance)
				&& timeoutMilliSecs > 0){
			Thread.sleep(pollIntervalMilliSecs);
			timeoutMilliSecs -= pollIntervalMilliSecs;
		}

		int actualAmount = helper.getMyAccount().getAccountBalance().getDollars();
        Assert.assertFalse("Expected account balance: " + accountBalance +
				", does not match actual account balance: " +
				helper.getMyAccount().getAccountBalance() +
				".", (accountBalance == helper.getMyAccount().getAccountBalance()));
    }
}

// mvn exec:java -Dexec.mainClass =" nicebank.AtmServer"
