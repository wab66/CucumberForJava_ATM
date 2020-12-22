package step_definitions;

import io.cucumber.java.Before;
import nicebank.BalanceStore;
import nicebank.TransactionQueue;

public class ResetHooks {
    @Before
    public void reset() {
        TransactionQueue.clear();
        BalanceStore.clear();
    }
}
