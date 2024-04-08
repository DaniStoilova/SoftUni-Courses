package com.example.football.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImport {
    @XmlElement(name="first-name")
    @NotNull
    @Size(min = 2)
    private String firstName;
    @XmlElement(name="last-name")
    @NotNull
    @Size(min = 2)
    private String lastName;
    @XmlElement
    @NotNull
    @Email
    private String email;

    @NotNull
    @XmlElement(name="birth-date")
    private String birthDate;

    @NotNull
    @XmlElement
    private String  position;

    @NotNull
    @XmlElement(name = "town")
    private TownBase town;
    @NotNull
    @XmlElement(name="team")
    private TeamBase team;
    @NotNull
    @XmlElement(name="stat")
    private StatBase stat;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public TownBase getTown() {
        return town;
    }

    public void setTown(TownBase town) {
        this.town = town;
    }

    public TeamBase getTeam() {
        return team;
    }

    public void setTeam(TeamBase team) {
        this.team = team;
    }

    public StatBase getStat() {
        return stat;
    }

    public void setStat(StatBase stat) {
        this.stat = stat;
    }
}
