package softuni.exam.domain.dto;
import softuni.exam.domain.entities.Position;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PlayerImport {

    @NotNull
    private String firstName;
    @NotNull
    @Size(min=3,max=15)
    private String lastName;
    @NotNull
    @Min(1)
    @Max(99)
    private Integer number;
    @NotNull
    private BigDecimal salary;
    @NotNull
    private Position position;
    @NotNull
    private PictureIm picture;

    @NotNull
    private TeamBase team;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PictureIm getPicture() {
        return picture;
    }

    public void setPicture(PictureIm picture) {
        this.picture = picture;
    }

    public TeamBase getTeam() {
        return team;
    }

    public void setTeam(TeamBase team) {
        this.team = team;
    }
}
