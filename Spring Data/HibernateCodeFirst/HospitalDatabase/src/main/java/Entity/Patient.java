package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="first_name",nullable = false, length = 30)
    private String firstName;

    @Column(name="last_name",nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column
    private Date birthDate;

    @Column
    private Blob picture;

    @Column(name = "medical_insurance")
    private boolean hasMedicalInsurance;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Visitation> visitations;


    @ManyToMany
    @JoinTable(name ="patient_diagnose",
            joinColumns = @JoinColumn(name = "patients_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnoses_id",referencedColumnName = "id"))
    private Set<Diagnose> diagnoses;


    @ManyToMany
    @JoinTable(name ="patient_medicament",
            joinColumns = @JoinColumn(name = "patients_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicaments_id",referencedColumnName = "id"))
    private Set<Medicament> medicaments;



}
