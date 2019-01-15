package service;

import exceptions.NoFundsException;

public interface TransferService {
    void withdraw(TransferTransaction transferTransactionVO) throws NoFundsException;
}
