package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import nicebank.TransactionQueue;
import org.javalite.activejdbc.Base;

public class HooksReset {
    @Before
    public void reset() {
        TransactionQueue.clear();
        //rc02: BalanceStore.clear();
    }
// rc999 - Can't do this when you have multiple threads.  Need to just start DB from scratch (delete all)
//    @After
//    public void rollback() {
//        Base.rollbackTransaction();
//    }
}
