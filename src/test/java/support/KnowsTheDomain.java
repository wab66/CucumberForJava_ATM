package support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.ITeller;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DBException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private ITeller teller;
    private EventFiringWebDriver webDriver;

    public KnowsTheDomain() {
        System.out.println("[KnowsTheDomain] > constructor");
        if (!Base.hasConnection()){
            //System.out.println("111111111111111111111 [KnowsTheDomain] > Constructor() -> 1a. NO BASE CONNECTION");
            Base.open(
                    "com.mysql.cj.jdbc.Driver",
                    "jdbc:mysql://localhost/bank",
                    "teller", "password");
            //System.out.println("1 --------------------- [KnowsTheDomain] > Constructor() -> 1a. Base.open - has connection created?: " + Base.hasConnection() + " Connection: " + Base.connection());
            System.out.println("[KnowsTheDomain] > Constructor() -> 1. Base.open() - Base.Account Table Count: " +
                    Base.count("bank.accounts"));
        }
        else {
            //System.out.println("2 --------------------- [KnowsTheDomain] > Constructor() -> 2a. Base already open - has connection created?: " + Base.hasConnection() + " Connection: " + Base.connection());
            System.out.println("[KnowsTheDomain] > Constructor() -> 2b. Base already open - Account Table Count: " +
                    Base.count("bank.accounts"));
        }

        try {
            System.out.println("[KnowsTheDomain] > constructor > 1. before - Account.deleteAll(): " + Base.count("bank.accounts"));
            Account.deleteAll();
            System.out.println("[KnowsTheDomain] > constructor > 2. after - Account.deleteAll(): " + Base.count("bank.accounts"));
        }catch(Exception e){
            System.out.println("[KnowsTheDomain] > constructor > Account.deleteAll() - exception: " + e);
        }
        System.out.println("[KnowsTheDomain] > constructor > end - debug");
    }

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account(1234);
            System.out.println("[KnowsTheDomain] > getMyAccount > (after) Create account if myAccount == null (not instantiated - but might be in DB)");
            try{
                myAccount.saveIt();
                System.out.println("[KnowsTheDomain] > getMyAccount > (after) myAccount.saveIt()");
            } catch(DBException e){
                System.out.println("[KnowsTheDomain] > getMyAccount > Account not added - already exists: " + e);
            }
        }
//        System.out.println("[KnowsTheDomain] > getMyAccount() > Getting account: " +
//                myAccount + ", Get myAccount Bal: " + myAccount.getAccountBalance());
        return myAccount;
    }

    public CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }

    public ITeller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface(getWebDriver());
        }
        return teller;
    }

    public EventFiringWebDriver getWebDriver() {
        if (webDriver == null){
            webDriver = new EventFiringWebDriver(new FirefoxDriver());
        }
        return webDriver;
    }
}
