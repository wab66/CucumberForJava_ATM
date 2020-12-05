package nicebank;

import nicebank.implementations.support.KnowsTheDomain;

public class Account {

	private double accountBalance;
	private String accountType;
//	private Locale locale;
//	private Currency currency;
	// Domain helper for sharing within the Step Definition
	/*public class AccountSteps{
		KnowsTheDomain helper;

	public AccountSteps() {
		helper = new KnowsTheDomain();
	}
}*/

	public Account() {
		//this.currency = Currency.getInstance(Locale.UK);
		this.accountBalance = 0;
		this.accountType = "";
	}

	public Account(double accountBalance, String accountType) {
		//this.currency = Currency.getInstance(Locale.UK);
		this.accountBalance = accountBalance;
		this.accountType = accountType;
	}

	public void credit(double depositAmount){
		accountBalance += depositAmount;
		System.out.println("Account has been credited " + depositAmount  + ",  Account Balance " +
				" is " + accountBalance );
	}

	public void debit(double withdrawAmount){
		accountBalance -= withdrawAmount;
		System.out.println("Account has been debited " + withdrawAmount  + ",  Account Balance " +
				" is " + accountBalance );
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}
}

