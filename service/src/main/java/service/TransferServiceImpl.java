package service;

import cache.TransactionCacheSingleton;
import db.AccountDataBaseSingleton;
import entities.Transaction;
import exceptions.NoFundsException;

public class TransferServiceImpl implements TransferService {

    @Override
    public void withdraw(TransferTransaction transferTransactionVO) throws NoFundsException {

        withDrawFromAccount(transferTransactionVO);

        depositToAccount(transferTransactionVO);
    }

    private void depositToAccount(TransferTransaction transferTransactionVO) {
        TransactionCacheSingleton.get().save(new Transaction(transferTransactionVO.to(),transferTransactionVO.value()));
    }

    private void withDrawFromAccount(TransferTransaction transferTransactionVO) throws NoFundsException {
        AccountDataBaseSingleton.get().withDraw(new Transaction(transferTransactionVO.from(),
                transferTransactionVO.value()));
    }
}
