package nicebank;

import nicebank.Account;

public interface ITeller {
    void withdrawFrom(Account account, int dollars);
}
