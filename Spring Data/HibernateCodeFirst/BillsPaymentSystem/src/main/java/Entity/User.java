package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table
public class User extends BaseEntity {
    //(first name, last name, email, password, billing details
    @Column(name = "first_name",length = 50,nullable = false)
    private String firstName;

    @Column(name = "last_name",length = 50,nullable = false)
    private String lastName;

    @Column(name = "email",length = 50,nullable = false)
    private String email;

    @Column(name = "password",length = 100,nullable = false)
    private String password;

    @OneToMany
    private Set<BillingDetails> billingDetails;

}
