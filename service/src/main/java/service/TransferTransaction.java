package service;

import java.math.BigDecimal;

public interface TransferTransaction {

    String sourceAcount();

    String to();

    BigDecimal value();
}
