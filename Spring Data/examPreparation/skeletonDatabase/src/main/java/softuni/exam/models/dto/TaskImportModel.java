package softuni.exam.models.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportModel {

    @XmlElement
    @NotNull
    private String date;
    @XmlElement
    @NotNull
    @Positive
    private Double price;

    @XmlElement
    @NotNull
    private CarBase car;

    @XmlElement
    @NotNull
    private MechanicBase mechanic;

    @XmlElement
    @NotNull
    private PartBase part;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CarBase getCar() {
        return car;
    }

    public void setCar(CarBase car) {
        this.car = car;
    }

    public MechanicBase getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicBase mechanic) {
        this.mechanic = mechanic;
    }

    public PartBase getPart() {
        return part;
    }

    public void setPart(PartBase part) {
        this.part = part;
    }
}
