package nicebank.implementations;

import nicebank.Account;

public interface ITeller {
    void withDrawFrom(Account account, float dollars);
}
