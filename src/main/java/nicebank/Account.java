package nicebank;

//import static java.lang.Integer.getInteger;
import org.javalite.activejdbc.Model;

public class Account extends Model{

	private TransactionQueue queue = new TransactionQueue();

	public Account(){}

	public Account(int number) {
		//rc02d this.queue = queue;
		System.out.println("[Account] > Account() > 1. before setInteger()");
		setInteger("number", number);
		setString("balance", "0.00");
		System.out.println("[Account] > Account() > 2. after setInteger() -> Account Count: " +
				Account.count() + ", Account Table name : " + Account.getTableName() +
				", Account first record :" + Account.findFirst("number = ?", 1234));
	}

	public void credit(Money amount) {
		//rc02: queue.write("+" + amount);
		System.out.println("##################### [Account] > credit() > Amount to be credited (write to Message Queue (" + amount.toString() + ") +  to account (" + getNumber() + ")");
		queue.write("+" + amount.toString() + "," + getNumber());
		//queue.write("+" );
	}

	public void debit(int amount) {
	//rc01m - public void debit(int dollars) {
		Money money = new Money(amount, 0);
		//rc02: queue.write("-" + money);
		queue.write("-" + money.toString() + "," + getNumber());
	}

	// Use DB
	public int getNumber() {
		return getInteger("number");
	}

	// Use DB
	public Money getAccountBalance() {
		System.out.println("[Account] > getAccountBalance() > about to do a 'refresh()'.  Current Balance before refresh: "+ getString("balance"));
		refresh();
		System.out.println("[Account] > getAccountBalance() > now get account balance");
		return new Money(getString("balance"));
	}

	// Use DB
	public void setAccountBalance(Money amount) {
		setString("balance", amount.toString().substring(1));
		saveIt();
	}

	//rc02: Using DB now as our source
//	public Money getAccountBalance() {
//		return BalanceStore.getBalance();
//	}



	// rc01: Updating this now to use a message queue instead, with a BalanceStore (this stores the balances)
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

