package service;


import db.AccountDataBaseSingleton;
import exceptions.NoFundsException;
import job.Job;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TransferServiceImplTest {

    private TransferService transferServiceImpl = new TransferServiceImpl();

    @Test
    public void shouldTransferWithSucces() throws NoFundsException {
        Transfer vo = getTransfer();
        transferServiceImpl.transfer(vo);
        new Job().run();
        BigDecimal joeBalance = AccountDataBaseSingleton.get().getBalance("joe");
        BigDecimal bobBalance = AccountDataBaseSingleton.get().getBalance("bob");
        assertEquals(0,BigDecimal.valueOf(50).compareTo(joeBalance));
        assertEquals(0,BigDecimal.valueOf(60).compareTo(bobBalance));
    }

    @Test(expected = NoFundsException.class)
    public void shouldTransferThrowError() throws NoFundsException {
        Transfer vo = getTransfer();
        transferServiceImpl.transfer(vo);
        new Job().run();
        transferServiceImpl.transfer(vo);
        new Job().run();
        transferServiceImpl.transfer(vo);
        new Job().run();
    }


    private Transfer getTransfer() {
        return new Transfer() {
                @Override
                public String getSourceAcount() {
                    return "joe";
                }

                @Override
                public BigDecimal getValue() {
                    return BigDecimal.valueOf(50);
                }

                @Override
                public String getDestinationAccount() {
                    return "bob";
                }
            };
    }


}