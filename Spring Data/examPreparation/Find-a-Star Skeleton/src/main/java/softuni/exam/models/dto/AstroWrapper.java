package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Field;
import java.util.List;

@XmlRootElement(name="astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstroWrapper {

    @XmlElement(name="astronomer")
    List<AstroImport> astronomer;

    public List<AstroImport> getAstronomer() {
        return astronomer;
    }

    public void setAstronomer(List<AstroImport> astronomer) {
        this.astronomer = astronomer;
    }
}
