package job;

import cache.TransactionCache;
import cache.TransactionCacheSingleton;
import db.AccountDataBase;
import db.AccountDataBaseSingleton;

public class Job implements Runnable {

    public void run() {
        AccountDataBase accountDataBase = AccountDataBaseSingleton.get();
        TransactionCache transactionCache = TransactionCacheSingleton.get();

        transactionCache.get().ifPresent(t->accountDataBase.deposit(t));
    }
}
