package softuni.exam.models.dto;

import softuni.exam.repository.ApartmentRepository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name="offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OffersImport {

    @XmlElement
    @Positive
    @NotNull
    private BigDecimal price;

    @XmlElement
    private AgentBase agent;

    @XmlElement
    private ApartmentBase apartment;

    @XmlElement(name = "publishedOn")
    @NotNull
    private String publishedOn;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentBase getAgent() {
        return agent;
    }

    public void setAgent(AgentBase agent) {
        this.agent = agent;
    }

    public ApartmentBase getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentBase apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
