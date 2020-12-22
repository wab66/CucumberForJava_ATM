package nicebank;

public class Account {

	private TransactionQueue queue = new TransactionQueue();

	public void credit(Money amount) {
		queue.write("+" + amount);
	}

	public void debit(int amount) {
	//rc01m - public void debit(int dollars) {
		Money money = new Money(amount, 0);
		queue.write("-" + money);
	}

	public Money getAccountBalance() {
		return BalanceStore.getBalance();
	}

	// Updating this now to use a message queue instead, with a BalanceStore (this stores the balances)
//	private double accountBalance;
//	private String accountType;
//
//	public Account() {
//		//this.currency = Currency.getInstance(Locale.UK);
//		this.accountBalance = 0;
//		this.accountType = "";
//	}
//
//	public Account(double accountBalance, String accountType) {
//		//this.currency = Currency.getInstance(Locale.UK);
//		this.accountBalance = accountBalance;
//		this.accountType = accountType;
//	}
//
//	public void credit(double depositAmount){
//		accountBalance += depositAmount;
//	}
//
//	public void debit(double withdrawAmount){
//		accountBalance -= withdrawAmount;
//	}
//
//	public double getAccountBalance() {
//		return accountBalance;
//	}
//
//	public String getAccountType() {
//		return accountType;
//	}
}

