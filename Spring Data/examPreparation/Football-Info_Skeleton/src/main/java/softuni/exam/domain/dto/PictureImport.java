package softuni.exam.domain.dto;


import javax.validation.constraints.NotEmpty;

public class PictureImport {

    @NotEmpty
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
