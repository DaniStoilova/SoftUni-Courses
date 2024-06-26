package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferWrapper {

    @XmlElement(name="offer")
    List<OffersImport> offers;

    public List<OffersImport> getOffers() {
        return offers;
    }

    public void setOffers(List<OffersImport> offers) {
        this.offers = offers;
    }
}
