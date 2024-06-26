package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Set;

@XmlRootElement(name="offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferImport {

    @XmlElement
    @NotNull
    @Size(min=5)
    private String description;

    @XmlElement
    @NotNull
    @Positive
    private BigDecimal price;
    @XmlElement(name="added-on")
    @NotNull
    private String addedOn;

    @XmlElement(name="has-gold-status")
    @NotNull
    private Boolean hasGoldStatus;

    @XmlElement
    @NotNull
    private CarBase car;
    @XmlElement
    @NotNull
    private SellerBase seller;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public Boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(Boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public CarBase getCar() {
        return car;
    }

    public void setCar(CarBase car) {
        this.car = car;
    }

    public SellerBase getSeller() {
        return seller;
    }

    public void setSeller(SellerBase seller) {
        this.seller = seller;
    }
}
