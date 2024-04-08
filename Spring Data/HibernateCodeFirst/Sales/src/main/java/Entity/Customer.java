package Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Customer extends BaseEntity{

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "email",length = 50)
    private String email;

    @Column
    private String creditCardNumber;

    @OneToMany
    private Set<Sale> sales;


}
