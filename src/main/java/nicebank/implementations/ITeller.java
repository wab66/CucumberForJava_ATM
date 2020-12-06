package nicebank.implementations;

import nicebank.Account;

public interface ITeller {
    void withdrawFrom(Account account, float dollars);
}
