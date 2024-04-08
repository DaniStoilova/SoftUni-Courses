package softuni.exam.domain.dto;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="team")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamImport {

    @XmlElement
    @Size(min=3,max=20)
     private String name;

    @XmlElement
    private PictureBase picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureBase getPicture() {
        return picture;
    }

    public void setPicture(PictureBase picture) {
        this.picture = picture;
    }
}
