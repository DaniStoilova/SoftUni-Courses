package Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="students")
public class Student extends PersonInfo {

    @Column(name="average_grade")
    private BigDecimal averageGrade;

    @Column(name="attendance")
    private int attendance;

    @ManyToMany
    private List<Course> courses;


}
