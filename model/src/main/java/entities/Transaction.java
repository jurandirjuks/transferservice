package entities;

import java.math.BigDecimal;

/**
 * @author jmneto
 * @version $Revision: $<br/>
 * $Id: $
 * @since 16/12/18 05:44
 */
public class Transaction {

    private BigDecimal value;

    private String accountName;

    public Transaction(String accountName, BigDecimal value) {
        this.accountName = accountName;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getAccountName() {
        return accountName;
    }
}
