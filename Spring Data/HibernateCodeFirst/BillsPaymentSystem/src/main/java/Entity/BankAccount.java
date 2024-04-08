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
public class BankAccount extends BillingDetails{

    @Column(name="bank_name",length = 30)
    private String name;

    @Column(name="SWIFT_code",length = 50)
    private String swiftCode;
}
