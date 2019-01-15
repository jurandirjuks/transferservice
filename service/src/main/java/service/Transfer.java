package service;

import java.math.BigDecimal;

/**
 * @author jmneto
 * @version $Revision: $<br/>
 * $Id: $
 * @since 15/01/19 21:03
 */
public interface Transfer {
    String getSourceAcount();

    BigDecimal getValue();

    String getDestinationAccount();
}
