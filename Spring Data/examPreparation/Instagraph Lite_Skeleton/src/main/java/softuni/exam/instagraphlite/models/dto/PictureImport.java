package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.*;

public class PictureImport {
    @NotNull
    private String path;
    @NotNull
    @Min(500)
    @Max(60000)
    private Double size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

}
