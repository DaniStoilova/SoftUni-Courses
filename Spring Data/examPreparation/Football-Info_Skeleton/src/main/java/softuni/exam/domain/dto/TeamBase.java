package softuni.exam.domain.dto;

import com.sun.istack.NotNull;

public class TeamBase {


    private String name;


    private PictureDTO picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureDTO getPictures() {
        return picture;
    }

    public void setPictures(PictureDTO pictures) {
        this.picture = picture;
    }
}
