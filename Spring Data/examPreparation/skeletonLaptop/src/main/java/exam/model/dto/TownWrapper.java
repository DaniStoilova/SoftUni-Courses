package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownWrapper {

    @XmlElement(name="town")
    private List<TownImport> towns;

    public List<TownImport> getTowns() {
        return towns;
    }

    public void setTowns(List<TownImport> towns) {
        this.towns = towns;
    }
}
