package Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table
public class CreditCard extends BillingDetails{

    // card type, expiration month, expiration year

    @Column(name ="card_type",length = 20, nullable = false)
    private String cardType;

    @Column(name ="expiration_month", nullable = false)
    private Short expirationMonth;

    @Column(name ="expiration_year", nullable = false)
    private Short expirationYear;
}
