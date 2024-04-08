package Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="teachers")
public class Teacher extends PersonInfo {

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="salary_per_hour",nullable = false)
    private BigDecimal salaryPerHour;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
