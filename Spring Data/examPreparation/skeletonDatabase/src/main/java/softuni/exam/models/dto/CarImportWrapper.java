package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name="cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportWrapper {

    @XmlElement(name = "car")
    @NotNull
     private List<CarImport> cars;

    public List<CarImport> getCars() {
        return cars;
    }

    public void setCars(List<CarImport> cars) {
        this.cars = cars;
    }
}
