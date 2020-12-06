package nicebank.implementations.support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.AutomatedTeller;
import nicebank.implementations.ITeller;

// Helper class
public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private ITeller teller;

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

}
