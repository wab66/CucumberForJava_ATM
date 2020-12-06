package nicebank;


import nicebank.implementations.ITeller;

public class AutomatedTeller implements ITeller {
    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public CashSlot getCashSlot() {
        return cashSlot;
    }

    @Override
    public void withdrawFrom(Account account, float amount) {
        account.debit(amount);
        cashSlot.dispense(amount);
    }
}
