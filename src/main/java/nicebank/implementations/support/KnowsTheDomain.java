package nicebank.implementations.support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.implementations.ITeller;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

// Helper class
public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private ITeller teller;
    private EventFiringWebDriver webDriver;

    public Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
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
            teller = new AtmUserInterface();
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
