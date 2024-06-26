package softuni.exam.models.dto;

import softuni.exam.models.entity.Apartment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name="apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentWrapper {

    @XmlElement(name="apartment")
    List<ApartmentImportDto> apartments;

    public List<ApartmentImportDto> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentImportDto> apartments) {
        this.apartments = apartments;
    }
}
