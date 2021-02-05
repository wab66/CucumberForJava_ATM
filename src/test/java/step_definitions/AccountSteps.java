
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

	public AccountSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}

	/*@ParameterType(".*")
	public Money money(String moneyAmount) {
		return new Money(moneyAmount);
	}*/

//--------------------------------------------------------------------------------------------------------------------
//	Desc:
//	The ATM posts messages about transactions into the Transaction Queue. The Transaction Processor reads messages off
//	that queue, reads the existing balance from the MySQL db(old way - Balance Store), and then stores the updated balance
//	back in the mySQL db (Balance Store). The ATM reads the account balance from the mySQL db (Balance Store).
//--------------------------------------------------------------------------------------------------------------------

	@ParameterType(name = "deposit", value = "\\d+\\.\\d+")
	public Money defineAmount(String value) {
		return new Money(value);
	}

	@Given("^my (.*?) account has been credited (\\d+\\.\\d\\d)?")
	//@Given("^my (.*?) account has been credited {deposit}?")
	public void myAccountHasBeenCredited(String account, Money deposit) throws Throwable {
	//public void myAccountHasBeenCredited(String account, @Transform(MoneyConverter.class) Money creditAmount) throws Throwable {
        System.out.println("################################ <Step - @GIVEN> - Account should be there: " + helper.getMyAccount());
        helper.getMyAccount().credit(deposit);
		System.out.println("################################ <Step - @GIVEN> - Account and amount to add has been written to Msg Queue - wait for it to be processed. " + helper.getMyAccount());
		//Money dbAccountBalance = helper.getMyAccount().getAccountBalance();
		//Assert.assertTrue("Incorrect account balance, expected: " + deposit + ", but actual was: " + dbAccountBalance, (deposit == dbAccountBalance));
	}
/*

	@When("^I withdraw (\\d+)$")
	public void iWithdraw(int withdrawAmount){
		helper.getTeller().withdrawFrom(helper.getMyAccount(), withdrawAmount);
		System.out.println("[@When] > Withdraw amount from teller, teller puts into cashslot: " + helper.getCashSlot().getContents());
	}
*/

	@When("^I transfer (\\d+\\.\\d\\d) from my (.*?) Account to my (.*?) Account?")
	public void iTransferFromMyAccountToMyAccount(float transferAmount, String fromAccount, String toAccount) {
	    //throw new io.cucumber.java.PendingException();
		System.out.println("ToDo: When - iTransferFromMyAccountToMyAccount");
	}

	// ToDo: The following 2 could be just on Then - "^the (.*?) Account will be (\\d+\\.\\d\\d)?"
/*

	@Then("^(\\d+) should be dispensed$")
	public void shouldBeDispensed(int dispenseAmount) {
		int actualDispenseAmount = helper.getCashSlot().getContents();
		Assert.assertTrue("Incorrect amount (" + dispenseAmount + ") dispensed. Actual amount was: (" +
				actualDispenseAmount + ").", dispenseAmount == actualDispenseAmount);
	}
*/

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

		System.out.println("[@THEN] > 1. About to enter While() > Get Account Balance: ");
		while (!helper.getMyAccount().getAccountBalance().equals(accountBalance)
				&& timeoutMilliSecs > 0){
			Thread.sleep(pollIntervalMilliSecs);
			timeoutMilliSecs -= pollIntervalMilliSecs;
			System.out.println("[@THEN] > 2. While() > Get Account Balance: " + helper.getMyAccount().getAccountBalance() +
					" and Compare to account balance (parm): " + accountBalance);
		}

		System.out.println("[@THEN] > 3. Get Account Balance: " + helper.getMyAccount().getAccountBalance() +
				" and Compare to account balance (parm): " + accountBalance);

		//int actualAmount = helper.getMyAccount().getAccountBalance().getDollars();
		Money actualAccountBalance = helper.getMyAccount().getAccountBalance();
        Assert.assertTrue("Expected account balance: " + accountBalance +
				", does not match actual account balance: " +
				actualAccountBalance +
				".", (accountBalance == actualAccountBalance));
    }
}

// mvn exec:java -Dexec.mainClass =" nicebank.AtmServer"
