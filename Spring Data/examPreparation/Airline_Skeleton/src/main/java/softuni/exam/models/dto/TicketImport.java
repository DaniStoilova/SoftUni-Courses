package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name="ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketImport {


    @NotNull
    @Size(min=2)
    @XmlElement(name="serial-number")
    private String serialNumber;
    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @XmlElement(name="take-off")
    private String  takeoff;

    @NotNull
    @XmlElement(name="from-town")
    private FromTownDTO fromTown;
    @NotNull
    @XmlElement(name="to-town")
    private ToTownDTO toTown;

    @NotNull
    @XmlElement
    private PassengerBase passenger;
    @NotNull
    @XmlElement
    private PlaneBase plane;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(String takeoff) {
        this.takeoff = takeoff;
    }

    public FromTownDTO getFromTown() {
        return fromTown;
    }

    public void setFromTown(FromTownDTO fromTown) {
        this.fromTown = fromTown;
    }

    public ToTownDTO getToTown() {
        return toTown;
    }

    public void setToTown(ToTownDTO toTown) {
        this.toTown = toTown;
    }

    public PassengerBase getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerBase passenger) {
        this.passenger = passenger;
    }

    public PlaneBase getPlane() {
        return plane;
    }

    public void setPlane(PlaneBase plane) {
        this.plane = plane;
    }
}
