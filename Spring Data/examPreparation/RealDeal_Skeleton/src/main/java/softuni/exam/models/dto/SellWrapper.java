package softuni.exam.models.dto;

import org.springframework.data.annotation.AccessType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellWrapper {

    @XmlElement(name="seller")
    List<SellImport> seller;

    public List<SellImport> getSeller() {
        return seller;
    }

    public void setSeller(List<SellImport> seller) {
        this.seller = seller;
    }
}
