package nicebank.implementations.support;

import nicebank.Account;
import nicebank.CashSlot;
import nicebank.AutomatedTeller;

// Helper class
public class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private AutomatedTeller automatedTeller;

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

    public AutomatedTeller getTeller() {
        if (automatedTeller == null) {
            //teller = new Teller(cashSlot);
            automatedTeller = new AutomatedTeller(cashSlot);
        }
        return automatedTeller;
    }
}
