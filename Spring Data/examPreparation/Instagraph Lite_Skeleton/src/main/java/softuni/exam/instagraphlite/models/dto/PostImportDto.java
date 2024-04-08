package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDto {

    @XmlElement(name="caption")
    @NotNull
    @Size(min = 21)
    private String caption;
    @XmlElement(name="user")
    @NotNull
    private UserBase user;
    @XmlElement(name="picture")
    @NotNull
    private PictureBase picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserBase getUser() {
        return user;
    }

    public void setUser(UserBase user) {
        this.user = user;
    }

    public PictureBase getPicture() {
        return picture;
    }

    public void setPicture(PictureBase picture) {
        this.picture = picture;
    }
}
