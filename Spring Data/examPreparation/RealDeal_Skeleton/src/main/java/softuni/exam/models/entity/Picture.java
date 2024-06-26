package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="pictures")
public class Picture extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private LocalDateTime dateAndTime;

    @ManyToOne
    private Car car;



    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
