package service;

import cache.TransactionCacheSingleton;
import db.AccountDataBaseSingleton;
import entities.Transaction;
import exceptions.NoFundsException;

public class TransferServiceImpl implements TransferService {

    @Override
    public void transfer(Transfer transfer) throws NoFundsException {

        withDrawFromAccount(transfer);

        depositToAccount(transfer);
    }

    private void depositToAccount(Transfer transfer) {
        TransactionCacheSingleton.get().save(new Transaction(transfer.getDestinationAccount(), transfer.getValue()));
    }

    private void withDrawFromAccount(Transfer transfer) throws NoFundsException {
        AccountDataBaseSingleton.get().withDraw(new Transaction(transfer.getSourceAcount(),
                transfer.getValue()));
    }
}
