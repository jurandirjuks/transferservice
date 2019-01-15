package db;

import entities.Transaction;
import exceptions.NoFundsException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jmneto
 * @version $Revision: $<br/>
 * $Id: $
 * @since 16/12/18 06:27
 */
public class AccountDataBase {

    private Map<String, List<BigDecimal>> database = new ConcurrentHashMap();

    public BigDecimal getBalance(String jura) {
        return database.getOrDefault(jura, Collections.emptyList())
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void deposit(Transaction transaction) {
        if (!this.database.containsKey(transaction.getAccountName())) {
            this.database.put(transaction.getAccountName(), new LinkedList());
        }
        this.database.get(transaction.getAccountName()).add(transaction.getValue());
    }

    public void withDraw(Transaction transaction) throws NoFundsException {
        if (haveSufficientFunds(transaction.getAccountName(), transaction.getValue())) {
            this.database.get(transaction.getAccountName()).add(transaction.getValue().negate());
        } else {
            throw new NoFundsException();
        }
    }

    private boolean haveSufficientFunds(String accountName, BigDecimal value) {
        return this.getBalance(accountName).compareTo(value) >= 0;
    }
}
