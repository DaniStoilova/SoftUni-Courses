package softuni.exam.domain.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureWrapper {

    @XmlElement(name="picture")
    List<PictureImport> picture;

    public List<PictureImport> getPicture() {
        return picture;
    }

    public void setPicture(List<PictureImport> picture) {
        this.picture = picture;
    }
}
