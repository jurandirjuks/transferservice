package service;

import exceptions.NoFundsException;

public interface TransferService {
    void transfer(Transfer transfer) throws NoFundsException;
}
