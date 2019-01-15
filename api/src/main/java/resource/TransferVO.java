package resource;

import service.Transfer;

import java.math.BigDecimal;

public class TransferVO implements Transfer {

    private String sourceAcount;

    private String destinationAccount;

    private BigDecimal value;

    @Override
    public String getSourceAcount() {
        return sourceAcount;
    }

    public void setSourceAcount(String sourceAcount) {
        this.sourceAcount = sourceAcount;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
