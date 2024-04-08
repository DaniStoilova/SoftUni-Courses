package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneWrapper {

    @XmlElement(name="plane")
    List<PlaneImport> plane;

    public List<PlaneImport> getPlane() {
        return plane;
    }

    public void setPlane(List<PlaneImport> plane) {
        this.plane = plane;
    }
}
