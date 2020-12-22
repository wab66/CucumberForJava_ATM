package nicebank;

public class AutomatedTeller implements ITeller {
    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public CashSlot getCashSlot() {
        return cashSlot;
    }

    @Override
    public void withdrawFrom(Account account, int amount) {
        System.out.println("[AutomatedTeller] > withdrawFrom() - first version of this method > otgher is in AtmUserInterface");
        account.debit(amount);
        cashSlot.dispense(amount);
    }
}
