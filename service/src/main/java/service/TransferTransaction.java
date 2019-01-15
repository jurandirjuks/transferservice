package service;

import java.math.BigDecimal;

public interface TransferTransaction {

    String from();

    String to();

    BigDecimal value();
}
