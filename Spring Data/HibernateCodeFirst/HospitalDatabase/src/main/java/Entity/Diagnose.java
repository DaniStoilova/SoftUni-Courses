package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 30)
    private String name;

    @Column(length = 100)
    private String comments;

    @ManyToMany(mappedBy = "diagnoses")
    private Set<Patient> patients;

}
